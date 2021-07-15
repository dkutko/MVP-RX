package com.petproj.mvprx.ui.presenters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.utils.SharedPrefs
import rx.Observable
import rx.schedulers.Schedulers


class UserListPresenter(private val view: IUserList) {

    private var listOfUsers = mutableListOf<User>()

    fun getUsers(): Observable<MutableList<User>> {
        return Observable.create<MutableList<User>> { sb ->
            //Transaction or network imitation
            Thread.sleep(1000)
            val users = SharedPrefs.getAllUsers()
            val gson = Gson()
            listOfUsers = gson.fromJson(users, object : TypeToken<MutableList<User?>?>() {}.type)
            sb.onNext(listOfUsers)
        }.subscribeOn(Schedulers.io())
    }


    interface IUserList {
        fun showProgressBar()
        fun hideProgressBar()
    }
}