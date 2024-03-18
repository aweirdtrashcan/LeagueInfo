package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class ChampionInfoDto(
    @SerializedName("attack")
    val attack: Int,
    @SerializedName("defense")
    val defense: Int,
    @SerializedName("magic")
    val magic: Int,
    @SerializedName("difficulty")
    val difficulty: Int
)
