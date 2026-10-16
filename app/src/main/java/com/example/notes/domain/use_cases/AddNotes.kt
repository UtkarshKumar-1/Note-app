package com.example.notes.domain.use_cases

import com.example.notes.domain.model.InvalidNoteException
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesRepository




class AddNotes (private val repository: NotesRepository){
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.desc.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")

        }
        repository.insert(note)
    }
}