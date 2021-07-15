package com.petproj.mvprx.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.petproj.mvprx.const.Constants
import com.petproj.mvprx.const.Constants.USERS

object SharedPrefs {
    lateinit var prefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    @SuppressLint("CommitPrefEdits")
    fun initPrefs(context: Context) {
        prefs = context.getSharedPreferences(
            Constants.MY_PREFS_NAME,
            Context.MODE_PRIVATE
        )
        editor = context.getSharedPreferences(
            Constants.MY_PREFS_NAME,
            Context.MODE_PRIVATE
        ).edit()
    }

    fun saveUsers(users: String) {
        editor.putString(USERS, users)
        editor.apply()
    }

    fun getAllUsers(): String {
        val users: String = prefs.getString(USERS, "")!!
        return users
    }
}