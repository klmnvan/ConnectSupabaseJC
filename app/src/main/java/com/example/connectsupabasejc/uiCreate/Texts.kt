package com.example.connectsupabasejc.uiCreate

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.connectsupabasejc.ui.theme.roboto

@Composable
fun TextMedium(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun TextMediumCenter(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextNormal(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun TextNormalCenter(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextBold(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextBoldCenter(text: String, modifier: Modifier?, fontSize: Int, color: Color){
    Text(
        text = text,
        modifier = modifier!!,
        color = color,
        fontSize = (fontSize-1).sp,
        fontFamily = roboto,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}
