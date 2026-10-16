package com.example.notes.data.mappers

import com.example.notes.data.local.NotesEntity
import com.example.notes.domain.model.Note


fun Note.toNoteEntity(): NotesEntity{
    return NotesEntity(id,title,desc,color,timestamp)
}

fun NotesEntity.toNote(): Note{
    return Note(id,title,desc,color,timestamp)
}