package com.example.notes.persentation.util



sealed class Screen(val route:String) {
    object NotesScreen:Screen("note_screen")
    object AddEditNoteScreen: Screen("add_edit_note_Screen")
}