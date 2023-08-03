package com.jsalin.oompaloompaapp.domain.item

import com.jsalin.oompaloompaapp.data.remote.model.Favorite
import com.jsalin.oompaloompaapp.data.remote.model.Result

data class OompaLoompaItem(
    val first_name: String,
    val image: String,
    val last_name: String,
    val gender: String,
    val profession: String,
    val country: String,
    val email: String,
    val favorite: Favorite,
)

fun Result.toOompaLoompaItem() = OompaLoompaItem(
    first_name,
    image,
    last_name,
    gender,
    profession,
    country,
    email,
    favorite
)
