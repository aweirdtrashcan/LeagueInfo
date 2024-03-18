package br.stimply.leagueinfo.feature_profile.data.mapper

import br.stimply.leagueinfo.feature_profile.data.model.SummonerDto
import br.stimply.leagueinfo.feature_profile.domain.model.Summoner

fun SummonerDto.toSummoner(): Summoner {
    return Summoner(
        profileIconId = profileIconId,
        name = name,
        summonerLevel = summonerLevel
    )
}