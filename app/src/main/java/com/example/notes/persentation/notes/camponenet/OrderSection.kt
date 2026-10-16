package com.example.notes.persentation.notes.camponenet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notes.domain.util.NoteOrder
import com.example.notes.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButtonSample(
                text = "Title",
                Selected = noteOrder is NoteOrder.Title,
                onSlected = { onOderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButtonSample(
                text = "Date",
                Selected = noteOrder is NoteOrder.Date,
                onSlected = { onOderChange(NoteOrder.Date(noteOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButtonSample(
                text = "Color",
                Selected = noteOrder is NoteOrder.Color,
                onSlected = { onOderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButtonSample(
                text = "Ascending",
                Selected = noteOrder.orderType is OrderType.Ascending,
                onSlected = { onOderChange(noteOrder.Copy(OrderType.Ascending)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButtonSample(
                text = "Descending",
                Selected = noteOrder.orderType is OrderType.Descending,
                onSlected = { onOderChange(noteOrder.Copy(OrderType.Descending)) }
            )
        }
    }
}

