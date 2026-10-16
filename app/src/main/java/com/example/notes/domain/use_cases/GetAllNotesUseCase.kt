package com.example.notes.domain.use_cases

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesRepository
import com.example.notes.domain.util.NoteOrder
import com.example.notes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(private val notesRepository: NotesRepository) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>>{
        return notesRepository.getAllNotes().map {
            notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }

                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }

                    }
                }

            }
        }
    }
}
