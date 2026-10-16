package com.example.notes.di


import com.example.notes.domain.use_cases.AddNotes
import com.example.notes.domain.use_cases.DeleteUseCase
import com.example.notes.domain.use_cases.GetAllNotesUseCase
import com.example.notes.domain.use_cases.GetNotesByIdUseCase
import com.example.notes.domain.use_cases.InsertUseCase
import com.example.notes.domain.use_cases.NotesUseCase

import org.koin.dsl.module

val DomainModule= module {
    factory {
        InsertUseCase(get())
    }

    factory {
        GetNotesByIdUseCase(get())
    }

    factory {
        DeleteUseCase(get())
    }
    factory {
        GetAllNotesUseCase(get())
    }
    factory {
        AddNotes(get())
    }


    factory {
        NotesUseCase(
            insertUseCase = get(),
            getNotesByIdUseCase = get(),
            deleteUseCase = get(),
            getAllNotesUseCase = get(),
            addNotes = get()

        )
    }
}