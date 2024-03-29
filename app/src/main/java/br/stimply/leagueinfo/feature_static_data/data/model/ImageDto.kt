package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("full")
    val full: String,
    @SerializedName("sprite")
    val sprite: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("x")
    val x: Int,
    @SerializedName("y")
    val y: Int,
    @SerializedName("w")
    val w: Int,
    @SerializedName("h")
    val h: Int
)
