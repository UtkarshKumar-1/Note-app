package com.example.notes.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val  Notes_Database="Notes_db"
@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDatabase: RoomDatabase() {
    companion object{
        fun getInstance(context: Context)=
            Room.databaseBuilder(context,NotesDatabase::class.java,Notes_Database)
                .build()

    }
    abstract fun getNotesDao(): NotesDao

}