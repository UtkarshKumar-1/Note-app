package com.example.notes.di


import com.example.notes.persentation.MainViewModel
import com.example.notes.persentation.add_edit_note.AddEditNoteViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val UiModule= module {
    viewModel {
        MainViewModel(
            notesUseCase = get()

        )
    }
    viewModel {
        AddEditNoteViewModel(
            notesUseCase = get(),
            savedStateHandle = get()
        )
    }

}