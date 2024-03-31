package com.example.connectsupabasejc.uiCreate

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CheckboxCustom(checked: Boolean, onCheckedChange: (Boolean) -> Unit, color: Color){
    Checkbox(
        checked = checked,
        onCheckedChange = { onCheckedChange(it) },
        colors = CheckboxDefaults.colors(
            uncheckedColor = color,
            checkedColor = color,
        )
    )
}