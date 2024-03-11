package br.stimply.leagueinfo.feature_account.presentation

import br.stimply.leagueinfo.feature_account.domain.model.Account

data class AccountState(
    val summonerName: String = "",
    val account: Account? = null,
    val isLoading: Boolean = false,
    val errorList: MutableList<String> = mutableListOf()
)
