package br.stimply.leagueinfo.feature_account.presentation

sealed class AccountEvent {
    data class OnSummonerChanged(val summoner: String): AccountEvent()
    data object OnSummonerSearch: AccountEvent()
    data object OnErrorDismissed: AccountEvent()
}