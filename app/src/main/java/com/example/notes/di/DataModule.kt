package com.example.notes.di

import com.example.notes.data.local.NotesDatabase
import com.example.notes.data.repository.NotesRepoImp
import com.example.notes.domain.repository.NotesRepository
import org.koin.dsl.module

val DataModule = module {
    single {
        NotesDatabase.getInstance(get())
    }
    single {
        get<NotesDatabase>().getNotesDao()
    }
    single<NotesRepository> {
        NotesRepoImp(get())
    }
}

