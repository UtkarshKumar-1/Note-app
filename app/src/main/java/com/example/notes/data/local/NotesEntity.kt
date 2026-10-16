package com.example.notes.data.local



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notes.ui.theme.Pink80
import com.example.notes.ui.theme.Purple80
import com.example.notes.ui.theme.PurpleGrey80


const val  Notes_Table="notes"

@Entity(tableName = Notes_Table)
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int?,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("desc") val desc: String,
    @ColumnInfo("color") val color: Int,
    @ColumnInfo("timestamp") val timestamp: Long


){
    constructor():this(0,"","",0,0)
    companion object{

        val notesColor=listOf(Purple80,PurpleGrey80, Pink80)
    }
}