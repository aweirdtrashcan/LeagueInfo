package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class DataDragonVersion(
    @SerializedName("n")
    val n: N,
    @SerializedName("v")
    val v: String,
    @SerializedName("l")
    val l: String,
    @SerializedName("cdn")
    val dataDragonUrl: String,
    @SerializedName("dd")
    val dd: String,
    @SerializedName("lg")
    val lg: String,
    @SerializedName("css")
    val css: String,
    @SerializedName("profileiconmax")
    val profileiconmax: Int,
)

// for some reason riot api just has a field called "n"

data class N(
    @SerializedName("item")
    val item: String,
    @SerializedName("rune")
    val rune: String,
    @SerializedName("mastery")
    val mastery: String,
    @SerializedName("summoner")
    val summoner: String,
    @SerializedName("champion")
    val champion: String,
    @SerializedName("profileicon")
    val profileIcon: String,
    @SerializedName("map")
    val map: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("sticker")
    val sticker: String
)

