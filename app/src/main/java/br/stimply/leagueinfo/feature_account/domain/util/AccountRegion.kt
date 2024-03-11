package br.stimply.leagueinfo.feature_account.domain.util

sealed class AccountRegion(val url: String) {
    data object Americas: AccountRegion("https://americas.api.riotgames.com")
    data object Asia: AccountRegion("https://asia.api.riotgames.com")
    data object Europe: AccountRegion("https://europe.api.riotgames.com")
}