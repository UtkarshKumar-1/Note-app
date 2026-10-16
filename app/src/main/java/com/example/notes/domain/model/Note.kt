package com.example.notes.domain.model

import com.example.notes.ui.theme.*


data class Note(
    val id: Int?,
    val title: String,
    val desc: String,
    val color: Int,
    val timestamp: Long
) {
    companion object {
        val noteColors = listOf(Purple80, PurpleGrey80, Pink80, Purple40, PurpleGrey40, Pink40)
    }
}

class InvalidNoteException(message: String): Exception(message)