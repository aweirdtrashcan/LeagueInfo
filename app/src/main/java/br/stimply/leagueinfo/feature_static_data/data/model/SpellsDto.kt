package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class SpellsDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("tooltip")
    val tooltip: String,
    @SerializedName("leveltip")
    val leveltip: LevelTipDto,
    @SerializedName("maxrank")
    val maxrank: Int,
    @SerializedName("cooldown")
    val cooldowns: List<Float>,
    @SerializedName("cooldownBurn")
    val cooldownBurn: String,
    @SerializedName("cost")
    val cost: List<Float>,
    @SerializedName("costBurn")
    val costBurn: String,
    @SerializedName("effect")
    val effects: List<List<Float>?>,
    @SerializedName("effectBurn")
    val effectBurn: List<String?>,
    @SerializedName("vars")
    val vars: List<Any?>,
    @SerializedName("costType")
    val costType: String,
    @SerializedName("maxammo")
    val maxAmmo: String,
    @SerializedName("range")
    val ranges: List<Float>,
    @SerializedName("rangeBurn")
    val rangeBurn: String,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("resource")
    val resource: String
)