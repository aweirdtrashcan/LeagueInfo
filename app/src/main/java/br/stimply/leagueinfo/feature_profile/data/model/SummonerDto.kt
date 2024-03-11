package br.stimply.leagueinfo.feature_profile.data.model

data class SummonerDto(
    val accountId: String,
    val profileIconId: String,
    val revisionDate: Long,
    val name: String,
    val id: String,
    val puuid: String,
    val summonerLevel: Long
)
