package com.example.connectsupabasejc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.connectsupabasejc.api.PrefManager
import com.example.connectsupabasejc.api.UserState
import com.example.connectsupabasejc.api.viewModels.AuthViewModel
import com.example.connectsupabasejc.ui.theme.ConnectSupabaseJCTheme
import com.example.connectsupabasejc.ui.theme.Gray2
import com.example.connectsupabasejc.uiCreate.AuthFieldComponent
import com.example.connectsupabasejc.uiCreate.AuthFieldPasswordComponent
import com.example.connectsupabasejc.uiCreate.ButtonBlueGrayMP
import com.example.connectsupabasejc.uiCreate.TextMedium
import com.example.rediexpressjc.uiCreate.Modifiers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConnectSupabaseJCTheme {
                PrefManager.init(LocalContext.current)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp(viewModel: AuthViewModel = AuthViewModel()) {
    val userState by viewModel.userState
    var currentUserState by remember { mutableStateOf("") }

    //Запускаем функцию из AuthViewModel, которая проверяет, есть ли авторизованный пользователь
    LaunchedEffect(Unit) {
        viewModel.isUserLoggedIn()
    }

    var inptName by remember { mutableStateOf("") }

    var inptPhone by remember { mutableStateOf("") }

    var inptEmail by remember { mutableStateOf("") }

    var inptPass1 by remember { mutableStateOf("") }

    var signUpIsClickable by remember { mutableStateOf(false) }
    var signInIsClickable by remember { mutableStateOf(false) }

    LaunchedEffect(inptName, inptPhone, inptEmail, inptPass1) {
        if (inptName.isNotEmpty() && inptPhone.isNotEmpty()
            && inptEmail.isNotEmpty() && inptPass1.isNotEmpty()) {
            signUpIsClickable = true
        } else {
            signUpIsClickable = false
        }
        if(inptEmail.isNotEmpty() && inptPass1.isNotEmpty()){
            signInIsClickable = true
        } else {
            signInIsClickable = false
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 30.dp)
    ) {
        Column {

            TextMedium("Full name",
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 20.dp), 14, Color(Gray2.value)
            )

            AuthFieldComponent(inptName, { inptName = it }, "Ivanov Ivan")

            TextMedium("Phone Number",
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp), 14, Color(Gray2.value))

            AuthFieldComponent(inptPhone, { inptPhone = it }, "+7(999)999-99-99")

            TextMedium("Email Address",
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp), 14, Color(Gray2.value))

            AuthFieldComponent(inptEmail, { inptEmail = it }, "***********@mail.com")

            TextMedium("Password",
                Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp), 14, Color(Gray2.value))

            AuthFieldPasswordComponent(inptPass1,
                //Передаем лямбда функцию, которая присвоит значение inptPass1 то значение,
                //которое будет вводить пользователь (onValueChange вернет и присовит это значение inptPass1)
                input = { it: String -> inptPass1 = it },
                "**********")

            ButtonBlueGrayMP(
                {
                    viewModel.signUp(inptEmail, inptPass1, inptName, inptPhone)
                    //viewModel.addUser(inptName, inptPhone)
                },
                Modifiers.MDBtnDefaultMP, signUpIsClickable, "Sign Up" )

            ButtonBlueGrayMP(
                {
                    viewModel.logIn(inptEmail, inptPass1)
                }, Modifiers.MDBtnDefaultMP,
                signInIsClickable, "Sign In")

            ButtonBlueGrayMP(
                {
                    viewModel.logout()
                }, Modifiers.MDBtnDefaultMP,
                true, "Log out")

            currentUserState = when (userState) {
                is UserState.Loading -> {
                    "Ожидание"
                }

                is UserState.Success -> {
                    (userState as UserState.Success).message
                }

                is UserState.Error -> {
                    val message = (userState as UserState.Error).message
                    message
                }
            }

            if (currentUserState.isNotEmpty()) {
                Text(text = "Статус: ${currentUserState}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

/*Для удобного Preview*/
@Preview(showBackground = true)
@Composable
private fun Preview() {
    ConnectSupabaseJCTheme {
        SignUp()
    }
}