package com.petproj.mvprx.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.glidePreloader
import com.petproj.mvprx.entity.User
import com.petproj.mvprx.title


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
//                url(it.picture)
                /**
                 * All images from json returns 404 error
                 */
                url("https://icon-library.com/images/no-user-image-icon/no-user-image-icon-14.jpg")
                spanSizeOverride { totalSpanCount, position, itemCount -> totalSpanCount / 2 }
            }
        }
    }
}