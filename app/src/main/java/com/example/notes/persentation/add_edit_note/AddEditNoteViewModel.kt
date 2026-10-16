package com.example.notes.persentation.add_edit_note


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.model.Note
import com.example.notes.domain.use_cases.NotesUseCase
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import com.example.notes.domain.model.InvalidNoteException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class AddEditNoteViewModel(
    private val notesUseCase: NotesUseCase,
    private val savedStateHandle: SavedStateHandle

): ViewModel() {
    private val _noteTitle = mutableStateOf<NotesTextFieldState>(
        NotesTextFieldState(
            hint = "Enter Title..."
        )
    )
    val noteTitle: State<NotesTextFieldState> = _noteTitle

    private val _noteDesc = mutableStateOf<NotesTextFieldState>(
        NotesTextFieldState(
            hint = "Enter Description..."
        )
    )
    val noteDesc: State<NotesTextFieldState> = _noteDesc

    private val _noteColor = mutableStateOf<Int>(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("notesId")?.let {notesId->
        if (notesId !=-1){
            viewModelScope.launch {
                notesUseCase.getNotesByIdUseCase(notesId)?.also {note->
                    currentNoteId=note.id
                    _noteTitle.value=noteTitle.value.copy(
                        text = note.title,
                        isHintVisible = false
                    )
                    _noteDesc.value=noteTitle.value.copy(
                        text = note.desc,
                        isHintVisible = false
                    )
                    _noteColor.value=note.color
                }

            }

        }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when(event){
            is AddEditNoteEvent.EnteredTitle->{
                _noteTitle.value=noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value=noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredDesc->{
                _noteDesc.value=noteDesc.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeDescFocus -> {
                _noteDesc.value=noteDesc.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteDesc.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.ChangeColor->{
                _noteColor.value=event.color
            }

            is AddEditNoteEvent.SaveNote->{
                viewModelScope.launch {
                    try {
                        notesUseCase.addNotes(
                            Note(
                                title = noteTitle.value.text,
                                desc = noteDesc.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId

                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)

                    }catch (e: InvalidNoteException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
            }

        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SaveNote: UiEvent()
    }
}

