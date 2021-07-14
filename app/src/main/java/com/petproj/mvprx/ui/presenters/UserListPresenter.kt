package com.petproj.mvprx.ui.presenters

import com.petproj.mvprx.entity.User

class UserListPresenter(private val view: IUserList) {

    var entries = mutableListOf<User>()

    fun refreshList() {
        entries.addAll(listOf())
        view.updateUserList(entries)
    }


    interface IUserList {
        fun updateUserList(list: MutableList<User>)
        fun showProgressBar()
        fun hideProgressBar()
    }
}