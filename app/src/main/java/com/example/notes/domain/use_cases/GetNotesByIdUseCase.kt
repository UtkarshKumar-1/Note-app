package com.example.notes.domain.use_cases

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesRepository

class GetNotesByIdUseCase (private val notesRepository: NotesRepository){
    suspend operator fun invoke(id: Int): Note? {
        return notesRepository.getNotesById(id)
    }
}





