package br.stimply.leagueinfo.feature_static_data.data.model

import com.google.gson.annotations.SerializedName

data class ChampionStatsDto(
    @SerializedName("hp")
    val hp: Float,
    @SerializedName("hpperlevel")
    val hpPerLevel: Float,
    @SerializedName("mp")
    val mp: Float,
    @SerializedName("mpperlevel")
    val mpPerLevel: Float,
    @SerializedName("movespeed")
    val movespeed: Float,
    @SerializedName("armor")
    val armor: Float,
    @SerializedName("armorperlevel")
    val armorPerLevel: Float,
    @SerializedName("spellblock")
    val spellBlock: Float,
    @SerializedName("spellblockperlevel")
    val spellBlockPerLevel: Float,
    @SerializedName("attackrange")
    val attackRange: Float,
    @SerializedName("hpregen")
    val hpRegen: Float,
    @SerializedName("hpregenperlevel")
    val hpRegenPerLevel: Float,
    @SerializedName("mpregen")
    val mpRegen: Float,
    @SerializedName("mpregenperlevel")
    val mpRegenPerLevel: Float,
    @SerializedName("crit")
    val crit: Float,
    @SerializedName("critperlevel")
    val critPerLevel: Float,
    @SerializedName("attackdamage")
    val attackDamage: Float,
    @SerializedName("attackdamageperlevel")
    val attackDamagePerLeve: Float,
    @SerializedName("attackspeedperlevel")
    val attackSpeedPerLevel: Float,
    @SerializedName("attackspeed")
    val attackSpeed: Float
)