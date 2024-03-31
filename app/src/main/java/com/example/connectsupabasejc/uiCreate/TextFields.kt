package com.example.connectsupabasejc.uiCreate

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.connectsupabasejc.R
import com.example.connectsupabasejc.ui.theme.Black
import com.example.connectsupabasejc.ui.theme.Gray1
import com.example.connectsupabasejc.ui.theme.Gray2
import com.example.connectsupabasejc.ui.theme.roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthFieldComponent(value: String, input: (String) -> Unit, placeholder: String) {
    OutlinedTextField(
        value = value,
        onValueChange = { input(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 8.dp),
        textStyle = TextStyle(
            fontFamily = roboto,
            fontWeight = FontWeight.Medium,
            color = Color(Black.value)
        ),
        placeholder = { TextMedium(placeholder, Modifier, 14, Color(Gray2.value)) },
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(Gray1.value),
            focusedBorderColor = Color(Gray1.value),
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthFieldPasswordComponent(value: String, input: (String) -> Unit, placeholder: String) {
    var visibilityPass by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = value,
        onValueChange = { value -> input(value) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .padding(top = 8.dp),
        textStyle = TextStyle(
            fontFamily = roboto,
            fontWeight = FontWeight.Medium,
            color = Color(Black.value)
        ),
        placeholder = { TextMedium(placeholder, Modifier, 14, Color(Gray2.value)) },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.icon_eye),
                contentDescription = "",
                modifier = Modifier
                    .size(15.dp)
                    .clickable {
                        visibilityPass = !visibilityPass
                    }
            )
        },
        shape = RoundedCornerShape(5.dp),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(Gray1.value),
            focusedBorderColor = Color(Gray1.value),
        ),
        visualTransformation = if (visibilityPass) VisualTransformation.None else PasswordVisualTransformation()
    )
}