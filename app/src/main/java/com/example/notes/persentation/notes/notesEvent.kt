package com.example.notes.persentation.notes


import com.example.notes.domain.model.Note
import com.example.notes.domain.util.NoteOrder


sealed class notesEvent {
    data class Order(val noteOrder: NoteOrder): notesEvent()
    data class DeleteNote(val note: Note): notesEvent()
    object RestoreNote: notesEvent()
    object ToggleOrderSection: notesEvent()

}