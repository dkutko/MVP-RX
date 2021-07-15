package com.petproj.mvprx.ui.presenters

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.utils.SharedPrefs


class UserListPresenter(private val view: IUserList) {

    private var listOfUsers = mutableListOf<User>()

    fun refreshList() {
        val users = SharedPrefs.getAllUsers()
        val gson = Gson()
        listOfUsers = gson.fromJson(users, object : TypeToken<MutableList<User?>?>() {}.type)
        view.showProgressBar()

        //Delay 2 sec
        Handler(Looper.getMainLooper()).postDelayed({
            view.updateUserList(listOfUsers)
            view.hideProgressBar()
        }, 2000)
    }


    interface IUserList {
        fun updateUserList(list: MutableList<User>)
        fun showProgressBar()
        fun hideProgressBar()
    }
}