package com.petproj.mvprx.ui.presenters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.petproj.mvprx.const.SortBy
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.utils.SharedPrefs
import rx.Observable
import rx.schedulers.Schedulers


class UserListPresenter(private val view: IUserList) {

    private var listOfUsers = mutableListOf<User>()

    fun getUsers(sortBy: SortBy): Observable<MutableList<User>> {
        return Observable.create<MutableList<User>> { sb ->
            //Transaction or network imitation
            val users = SharedPrefs.getAllUsers()
            val gson = Gson()
            listOfUsers = gson.fromJson(users, object : TypeToken<MutableList<User?>?>() {}.type)
            sortList(sortBy, listOfUsers)
            sb.onNext(listOfUsers)
        }.subscribeOn(Schedulers.io())
    }

    private fun sortList(sortBy: SortBy, listOfUsers: MutableList<User>) {
        if (sortBy == SortBy.ASCENDING) {
            listOfUsers.sortWith { o1, o2 ->
                val p1: User = o1 as User
                val p2: User = o2 as User
                p1.name!!.compareTo(p2.name!!)
            }
        } else {
            listOfUsers.sortWith { o1, o2 ->
                val p1: User = o1 as User
                val p2: User = o2 as User
                p1.name!!.compareTo(p2.name!!)
            }
            listOfUsers.reverse()
        }
    }


    interface IUserList {
        fun showProgressBar()
        fun hideProgressBar()
    }
}