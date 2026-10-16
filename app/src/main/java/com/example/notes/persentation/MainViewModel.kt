package com.example.notes.persentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.domain.model.Note
import com.example.notes.domain.use_cases.NotesUseCase
import com.example.notes.domain.util.NoteOrder
import com.example.notes.domain.util.OrderType
import com.example.notes.persentation.notes.NotesState
import com.example.notes.persentation.notes.notesEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val notesUseCase: NotesUseCase,

): ViewModel() {

    private val _state = MutableStateFlow(NotesState())
    val state: MutableStateFlow<NotesState> = _state
    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: notesEvent) {
        when (event) {
            is notesEvent.Order -> {
                if (state.value.noteOrder::class == event.noteOrder::class &&
                    state.value.noteOrder.orderType == event.noteOrder.orderType
                ) {
                    return
                }
                getNotes(event.noteOrder)
            }

            is notesEvent.DeleteNote -> {
                viewModelScope.launch {
                    notesUseCase.deleteUseCase(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is notesEvent.RestoreNote -> {
                viewModelScope.launch {
                    notesUseCase.addNotes(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is notesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisibility = !state.value.isOrderSectionVisibility
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = notesUseCase.getAllNotesUseCase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
        .launchIn(viewModelScope)
    }
}