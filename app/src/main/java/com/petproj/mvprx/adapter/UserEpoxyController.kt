package com.petproj.mvprx.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.title
import com.petproj.mvprx.user


class UserEpoxyController : TypedEpoxyController<MutableList<User>>() {


    override fun buildModels(data: MutableList<User>) {
        title {
            id("id")
            title("All Users")
            spanSizeOverride { totalSpanCount, position, itemCount -> totalSpanCount / 1 }
        }

        data.forEach {
            user {
                name(it.name)
                id(it._id)
                spanSizeOverride { totalSpanCount, position, itemCount -> totalSpanCount / 2 }
            }
        }
    }
}