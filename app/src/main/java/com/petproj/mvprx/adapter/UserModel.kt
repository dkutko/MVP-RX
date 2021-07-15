package com.petproj.mvprx.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.petproj.mvprx.R
import kotlinx.android.synthetic.main.user_item.view.*

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.user_item)
abstract class UserModel: EpoxyModelWithHolder<UserModel.UserHolder>() {

    @EpoxyAttribute
    var name: String? = ""
    @EpoxyAttribute
    var about: String? = ""

    override fun bind(holder: UserHolder) {
        holder.entryName.text = name
    }

    inner class UserHolder: EpoxyHolder() {
        lateinit var entryName: TextView

        override fun bindView(itemView: View) {
            entryName = itemView.userName
        }
    }
}