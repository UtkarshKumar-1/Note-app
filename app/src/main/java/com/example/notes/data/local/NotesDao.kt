package com.example.notes.data.local


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insert(notesEntity: NotesEntity)

    @Query("SELECT *FROM notes WHERE id=:id")
    suspend fun getNotesById(id: Int): NotesEntity?
    @Delete
    suspend fun delete(notesEntity: NotesEntity)

    @Query("SELECT *FROM notes")
    fun getAllNotes(): Flow<List<NotesEntity>>
}