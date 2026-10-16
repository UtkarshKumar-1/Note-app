package com.example.notes.data.repository

import com.example.notes.data.local.NotesDao
import com.example.notes.data.mappers.toNote
import com.example.notes.data.mappers.toNoteEntity
import com.example.notes.domain.model.Note
import com.example.notes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NotesRepoImp(private val notesDao: NotesDao): NotesRepository {
    override suspend fun insert(note: Note) {
        notesDao.insert(note.toNoteEntity())
    }

    override suspend fun getNotesById(id: Int): Note? {
        return notesDao.getNotesById(id = id)?.toNote()
    }


    override suspend fun delete(note: Note) {
        notesDao.delete(note.toNoteEntity())
    }

    override fun getAllNotes(): Flow<List<Note>> =
        notesDao.getAllNotes().map { entities ->
            entities.map { it.toNote() }
        }
}