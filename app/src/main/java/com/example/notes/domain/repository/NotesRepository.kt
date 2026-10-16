package com.example.notes.domain.repository

import com.example.notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun insert(note: Note)

    suspend fun getNotesById(id: Int): Note?

    suspend fun delete(note: Note)

    fun getAllNotes(): Flow<List<Note>>
}