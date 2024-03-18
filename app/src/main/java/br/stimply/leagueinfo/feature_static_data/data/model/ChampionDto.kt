package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class ChampionDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: ImageDto,
    @SerializedName("skins")
    val skins: List<SkinsDto>,
    @SerializedName("lore")
    val lore: String,
    @SerializedName("allytips")
    val allyTips: List<String>,
    @SerializedName("enemytips")
    val enemyTips: List<String>,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("partype")
    val parType: String,
    @SerializedName("info")
    val info: ChampionInfoDto,
    @SerializedName("stats")
    val stats: ChampionStatsDto,
    @SerializedName("spells")
    val spells: List<SpellsDto>,

)