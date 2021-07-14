package com.petproj.mvprx.ui.presenters

import com.petproj.mvprx.entity.Entry

class UserListPresenter(val view: IUserList) {

    var entries = mutableListOf<Entry>()

    fun refreshList() {
        entries.addAll(listOf(Entry("Data"), Entry("Main"), Entry("Sup")))
        view.updateUserList(entries)
    }


    interface IUserList {
        fun updateUserList(list: MutableList<Entry>)
        fun showProgressBar()
        fun hideProgressBar()
    }
}