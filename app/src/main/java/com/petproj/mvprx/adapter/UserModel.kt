package com.petproj.mvprx.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.petproj.mvprx.R


@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_user)
abstract class UserModel : EpoxyModelWithHolder<UserModel.HeaderViewHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var url: String

    override fun bind(holder: HeaderViewHolder) {
        super.bind(holder)
        holder.name.text = name
        holder.glide.load(url).centerInside().placeholder(R.drawable.bg_image).into(holder.picture)
    }

    class HeaderViewHolder : EpoxyHolder() {
        lateinit var name: TextView
        lateinit var picture: ImageView
        lateinit var glide: RequestManager
        override fun bindView(itemView: View) {
            name = itemView.findViewById(R.id.name)
            picture = itemView.findViewById(R.id.ivPicture)
            glide = Glide.with(picture.context)
        }
    }
}