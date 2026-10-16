package com.example.notes.domain.use_cases

import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesRepository

class InsertUseCase(private val notesRepository: NotesRepository) {
    suspend operator fun invoke(note: Note){
        notesRepository.insert(note)
    }
}