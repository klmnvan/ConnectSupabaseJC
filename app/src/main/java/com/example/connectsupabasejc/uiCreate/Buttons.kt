package com.example.connectsupabasejc.uiCreate

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.connectsupabasejc.ui.theme.Blue
import com.example.connectsupabasejc.ui.theme.Gray2
import com.example.connectsupabasejc.ui.theme.roboto

//MP - match_parent
//WP - wrap_content

@Composable
fun ButtonBlueGrayMP(click: () -> Unit, modifier: Modifier, buttonIsBlue: Boolean, text: String){
    val colorBtnBlue = ButtonDefaults.outlinedButtonColors(
        contentColor = Color(Blue.value),
        containerColor = Color(Blue.value)
    )
    val colorBtnGray = ButtonDefaults.outlinedButtonColors(
        contentColor = Color(Gray2.value),
        containerColor = Color(Gray2.value)
    )
    Button(
        onClick = click,
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
        colors = if (buttonIsBlue) colorBtnBlue else colorBtnGray
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            color = Color(0xFFFFFFFF),
            fontFamily = roboto,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ButtonBlueGrayWC(click: () -> Unit, modifier: Modifier, buttonIsBlue: Boolean, text: String){
    val colorBtnBlue = ButtonDefaults.outlinedButtonColors(
        contentColor = Color(Blue.value),
        containerColor = Color(Blue.value)
    )
    val colorBtnGray = ButtonDefaults.outlinedButtonColors(
        contentColor = Color(Gray2.value),
        containerColor = Color(Gray2.value)
    )
    Button(
        onClick = click,
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
        colors = if (buttonIsBlue) colorBtnBlue else colorBtnGray
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 15.dp),
            color = Color(0xFFFFFFFF),
            fontFamily = roboto,
            fontWeight = FontWeight.Bold
        )
    }
}

