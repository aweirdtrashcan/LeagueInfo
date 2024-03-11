package br.stimply.leagueinfo.feature_account.domain.repository

import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun getAccount(gameName: String, tagLine: String): Flow<Resource<Account>>
}