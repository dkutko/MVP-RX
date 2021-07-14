package com.petproj.mvprx.ui.presenters

import android.os.Handler
import android.os.Looper
import com.petproj.mvprx.entity.User

class UserListPresenter(private val view: IUserList) {

    var entries = mutableListOf<User>()

    fun refreshList() {
        entries.addAll(listOf(User(name = "Cass"), User(name = "John"), User(name = "Otto")))
        view.showProgressBar()

        //Delay 2 sec
        Handler(Looper.getMainLooper()).postDelayed({
            view.updateUserList(entries)
            view.hideProgressBar()
        }, 2000)
    }


    interface IUserList {
        fun updateUserList(list: MutableList<User>)
        fun showProgressBar()
        fun hideProgressBar()
    }
}