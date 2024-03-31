package com.example.connectsupabasejc.api.viewModels

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectsupabasejc.api.PrefManager
import com.example.connectsupabasejc.api.SupabaseClient.supabase
import com.example.connectsupabasejc.api.UserState
import com.example.connectsupabasejc.models.UserModel
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch


class AuthViewModel: ViewModel() {
    private val _userState = mutableStateOf<UserState>(UserState.Loading)
    val userState: State<UserState> = _userState

    fun signUp(userEmail: String, userPassword: String, name: String, phone: String) {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                supabase.auth.signUpWith(Email) {
                    email = userEmail
                    password = userPassword
                }
                saveToken()
                addUser(name, phone)
                _userState.value = UserState.Success("Вы успешно зарегистрировались")
            } catch(e: Exception) {
                _userState.value = UserState.Error(e.message ?: "")
            }

        }
    }

    fun addUser(name: String, phone: String){
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                val user = UserModel().copy(
                    id = supabase.auth.currentUserOrNull()!!.id,
                    name = name,
                    phone = phone)
                supabase.from("users").insert(user)
            } catch (e: Exception){
                _userState.value = UserState.Error("Error addUser: " + e.message.toString())
            }
        }
    }

    private fun saveToken() {
        viewModelScope.launch {
            val accessToken = supabase.auth.currentAccessTokenOrNull()
            val accessUUID = supabase.auth.currentUserOrNull()!!.id
            PrefManager.token = accessToken
            PrefManager.uuid = accessUUID
        }

    }

    private fun getToken(): String? {
        return PrefManager.token
    }

    private fun getUUID(): String? {
        return PrefManager.uuid
    }

    fun logIn(userEmail: String, userPassword: String) {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                supabase.auth.signInWith(Email) {
                    email = userEmail
                    password = userPassword
                }
                saveToken()
                _userState.value = UserState.Success("Вы успешно вошли в аккаунт")
            } catch (e: Exception) {
                _userState.value = UserState.Error(e.message ?: "")
            }

        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                supabase.auth.signOut()
                PrefManager.token = ""
                _userState.value = UserState.Success("Вы вышли из аккаунта")
            } catch (e: Exception) {
                _userState.value = UserState.Error(e.message ?: "")
            }
        }
    }

    fun isUserLoggedIn() {
        viewModelScope.launch {
            try {
                _userState.value = UserState.Loading
                val token = getToken()
                val uuid = getUUID()
                if(token.isNullOrEmpty()) {
                    _userState.value = UserState.Success("Пользователь не авторизован")
                } else {
                    supabase.auth.retrieveUser(token)
                    supabase.auth.refreshCurrentSession()
                    saveToken()
                    _userState.value = UserState.Success("Пользователь авторизован, uuid: ${uuid}")
                }
            } catch (e: RestException) {
                _userState.value = UserState.Error(e.error)
            }
        }
    }

}