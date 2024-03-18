package br.stimply.leagueinfo.feature_profile.domain.util

sealed class SummonerRegion(val url: String) {
    data object Brazil: SummonerRegion("https://br1.api.riotgames.com")
    data object EuropeNorth: SummonerRegion("https://eun1.api.riotgames.com")
    data object EuropeWest: SummonerRegion("https://euw1.api.riotgames.com")
    data object Japan: SummonerRegion("https://jp1.api.riotgames.com")
    data object Korea: SummonerRegion("https://kr.api.riotgames.com")
    data object Latam1: SummonerRegion("https://la1.api.riotgames.com")
    data object Latam2: SummonerRegion("https://la2.api.riotgames.com")
    data object NorthAmerica: SummonerRegion("https://na1.api.riotgames.com")
    data object Oceania: SummonerRegion("https://oc1.api.riotgames.com")
    data object Russia: SummonerRegion("https://ru.api.riotgames.com")
}