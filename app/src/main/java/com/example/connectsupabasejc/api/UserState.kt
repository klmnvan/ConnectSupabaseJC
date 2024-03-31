package com.example.connectsupabasejc.api

sealed class UserState {
    object Loading: UserState()
    data class Success(val message: String): UserState()
    data class Error(val message: String): UserState()
}