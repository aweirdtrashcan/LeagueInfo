package br.stimply.leagueinfo.feature_profile.domain.repository

import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_profile.domain.model.Summoner
import br.stimply.leagueinfo.feature_profile.domain.util.SummonerRegion
import kotlinx.coroutines.flow.Flow

interface SummonerRepository {

    suspend fun getSummoner(region: SummonerRegion, account: Account): Flow<Resource<Summoner>>
}