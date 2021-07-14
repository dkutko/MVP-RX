package com.petproj.mvprx.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.petproj.mvprx.R
import com.petproj.mvprx.adapter.entry
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.ui.presenters.UserListPresenter
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : Fragment(), UserListPresenter.IUserList {

    var presenter: UserListPresenter = UserListPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.refreshList()
    }

    override fun updateUserList(list: MutableList<User>) {
        rvUsers.withModels {
            list.forEach {
                entry {
                    id(hashCode())
                    name(it.name)
                }
            }
        }
    }


    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }

}