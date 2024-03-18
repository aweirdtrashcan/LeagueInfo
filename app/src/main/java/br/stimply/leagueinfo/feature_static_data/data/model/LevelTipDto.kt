package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class LevelTipDto(
    @SerializedName("label")
    val labels: List<String>,
    @SerializedName("effect")
    val effects: List<String>,
)
