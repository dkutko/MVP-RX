package com.petproj.mvprx.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.petproj.mvprx.R
import com.petproj.mvprx.adapter.UserEpoxyController
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.ui.presenters.UserListPresenter
import kotlinx.android.synthetic.main.fragment_user_list.*

class UserListFragment : Fragment(), UserListPresenter.IUserList {

    private var presenter: UserListPresenter = UserListPresenter(this)
    private val epoxyController = UserEpoxyController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_list, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        presenter.refreshList()
    }

    private fun initRecyclerView() {
        val spanCount = 2
        val layoutManager = GridLayoutManager(context, spanCount)
        epoxyController.spanCount = spanCount
        layoutManager.spanSizeLookup = epoxyController.spanSizeLookup
        rvUsers.layoutManager = layoutManager
    }

    override fun updateUserList(list: MutableList<User>) {
        epoxyController.setData(list)
        rvUsers.setController(epoxyController)
    }


    override fun showProgressBar() {
        rvUsers.visibility = View.GONE
        progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressbar.visibility = View.GONE
        rvUsers.visibility = View.VISIBLE
    }

}