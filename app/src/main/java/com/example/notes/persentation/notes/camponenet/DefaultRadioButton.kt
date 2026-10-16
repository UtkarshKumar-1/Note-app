package com.example.notes.persentation.notes.camponenet



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultRadioButtonSample(
    text: String,
    Selected: Boolean,
    onSlected: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier= Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        RadioButton(
            selected = Selected,
            onClick = onSlected,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier= Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }


}
