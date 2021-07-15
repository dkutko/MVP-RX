package com.petproj.mvprx.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.petproj.mvprx.R
import com.petproj.mvprx.ui.presenters.MainActivityPresenter
import com.petproj.mvprx.utils.SharedPrefs

class MainActivity : AppCompatActivity() {
    private val presenter: MainActivityPresenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSharedPreferences()
    }

    private fun initSharedPreferences() {
        SharedPrefs.initPrefs(this)
        presenter.prepareUsers(this)
    }
}