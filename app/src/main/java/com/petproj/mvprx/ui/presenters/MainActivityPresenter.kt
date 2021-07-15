package com.petproj.mvprx.ui.presenters

import android.content.Context
import com.petproj.mvprx.utils.JsonReader
import com.petproj.mvprx.utils.SharedPrefs


class MainActivityPresenter {
    fun prepareUsers(context: Context) {
        val users = JsonReader.readFile(context)
        SharedPrefs.saveUsers(users)
    }
}