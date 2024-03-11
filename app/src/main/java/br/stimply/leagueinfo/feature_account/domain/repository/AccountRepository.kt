package br.stimply.leagueinfo.feature_account.domain.repository

import br.stimply.leagueinfo.feature_account.domain.Account
import br.stimply.leagueinfo.util.Resource
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun getAccount(gameName: String, tagLine: String): Flow<Resource<Account>>
}