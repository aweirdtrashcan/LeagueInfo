package br.stimply.leagueinfo.feature_account.data.mapper

import br.stimply.leagueinfo.feature_account.data.model.AccountDto
import br.stimply.leagueinfo.feature_account.domain.model.Account

fun AccountDto.toAccount(): Account {
    return Account(
        puuid = puuid,
        gameName = gameName,
        tagLine = tagLine
    )
}