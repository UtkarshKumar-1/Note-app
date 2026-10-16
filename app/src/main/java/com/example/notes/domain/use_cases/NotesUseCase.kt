package com.example.notes.domain.use_cases




data class NotesUseCase(
    val insertUseCase: InsertUseCase,
    val getNotesByIdUseCase: GetNotesByIdUseCase,
    val deleteUseCase: DeleteUseCase,
    val getAllNotesUseCase: GetAllNotesUseCase,
    val addNotes: AddNotes
)
