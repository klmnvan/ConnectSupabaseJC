package com.example.connectsupabasejc.api

import android.annotation.SuppressLint
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.ExternalAuthAction
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SupabaseClient {
    @SuppressLint("VisibleForTests")
    val supabase = createSupabaseClient(
        supabaseUrl = "https://rqotastukkhgkxberaht.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJxb3Rhc3R1a2toZ2t4YmVyYWh0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTEyMDkyNzUsImV4cCI6MjAyNjc4NTI3NX0.0psgkOniteZrmybKUOC7xm2bvFTESLafhbZU2wpFvXI"
    ) {
        install(Auth)
        {
            scheme = "com.example.connectsupabasejc"
            host = "login-callback"
            alwaysAutoRefresh = true
            autoLoadFromStorage = true
            autoSaveToStorage = true
            defaultExternalAuthAction = ExternalAuthAction.CUSTOM_TABS
        }
        install(Postgrest)
        /*install(ComposeAuth){
            googleNativeLogin(serverClientId = "237422287964-tt9i1g8ugdq3ajj7kaa4so4jbpq9nbl4.apps.googleusercontent.com")
        }*/
        install(Storage)
    }

}