package com.example.connectsupabasejc.api

import android.content.Context
import android.content.SharedPreferences

object PrefManager {
    private lateinit var spAct: SharedPreferences
    private lateinit var spUser: SharedPreferences

    fun init(context: Context){
        spAct = context.getSharedPreferences("ActSystem", Context.MODE_PRIVATE)
        spUser = context.getSharedPreferences("UserSystem", Context.MODE_PRIVATE)
    }

    var act: Int
        get() = spAct.getInt("act", 0)
        set(value) = spAct.edit().putInt("act", value).apply()

    var token: String?
        get() = spUser.getString("token", "") //get
        set(value) = spUser.edit().putString("token", value).apply() //save

    var uuid: String?
        get() = spUser.getString("uuid", "") //get
        set(value) = spUser.edit().putString("uuid", value).apply() //save
}