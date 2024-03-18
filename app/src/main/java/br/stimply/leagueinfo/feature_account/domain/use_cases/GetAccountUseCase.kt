package br.stimply.leagueinfo.feature_account.domain.use_cases

import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_account.domain.repository.AccountRepository
import br.stimply.leagueinfo.core.domain.Resource
import kotlinx.coroutines.flow.Flow

class GetAccountUseCase(
    private val repository: AccountRepository
) {
    suspend operator fun invoke(summonerName: String): Flow<Resource<Account>> {
        val summonerSplit = summonerName.split("#")
        val gameName = summonerSplit[0]
        val tagLine = summonerSplit[1]
        return repository.getAccount(gameName, tagLine)
    }
}