package br.stimply.leagueinfo.feature_profile.domain.use_cases

import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_profile.domain.model.Summoner
import br.stimply.leagueinfo.feature_profile.domain.repository.SummonerRepository
import br.stimply.leagueinfo.feature_profile.domain.util.SummonerRegion
import kotlinx.coroutines.flow.Flow

class GetSummonerUseCase(
    private val repository: SummonerRepository
) {
    suspend operator fun invoke(region: SummonerRegion, account: Account): Flow<Resource<Summoner>> {
        return repository.getSummoner(region, account)
    }
}