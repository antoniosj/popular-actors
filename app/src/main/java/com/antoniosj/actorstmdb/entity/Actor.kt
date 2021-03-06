package com.antoniosj.actorstmdb.entity

import com.antoniosj.actorstmdb.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Actor(
    var id: Int,
    var name: String,
    //@SerializedName("profile_path")
    profilePath: String,
    var adult: Boolean,
    var popularity: Float,
    var biography: String,
    var placeOfBirth: String
) : Serializable {
    @SerializedName("profile_path")
    val profilePath = profilePath
        get() = Constants.IMAGE_PATH_BASE + field

    //just for debug purpose
    override fun toString(): String = "name: $name profile: $profilePath is Adult? $adult"
}