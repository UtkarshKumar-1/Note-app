package com.example.notes.persentation.add_edit_note

data class NotesTextFieldState(
    val text: String="",
    val hint: String="",
    val isHintVisible: Boolean=true
)