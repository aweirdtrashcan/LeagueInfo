package br.stimply.leagueinfo.feature_profile.data.repository

import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_profile.data.mapper.toSummoner
import br.stimply.leagueinfo.feature_profile.data.remote.SummonerAPI
import br.stimply.leagueinfo.feature_profile.domain.model.Summoner
import br.stimply.leagueinfo.feature_profile.domain.repository.SummonerRepository
import br.stimply.leagueinfo.feature_profile.domain.util.SummonerRegion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class SummonerRepositoryImpl(
    private val summonerAPI: SummonerAPI
) : SummonerRepository {

    override suspend fun getSummoner(region: SummonerRegion, account: Account): Flow<Resource<Summoner>> {
        return withContext(Dispatchers.IO) {
            flow {
                emit(Resource.Loading(true))
                val query = SummonerAPI.createRequestUrl(region, account)
                try {
                    val remoteSummoner = summonerAPI.getSummoner(query)
                    emit(Resource.Success(remoteSummoner.toSummoner()))
                    emit(Resource.Loading(false))
                } catch (e: IOException) {
                    println("Error getting Summoner: ${e.message ?: "Unknown error"}")
                    emit(Resource.Loading(false))
                    emit(Resource.Error("Failed to get Summoner from the Internet."))
                } catch (e: HttpException) {
                    println("Error getting Summoner: ${e.code()} ${e.message()}")
                    emit(Resource.Loading(false))
                    emit(Resource.Error("Failed to get Summoner from the Internet."))
                }
            }
        }
    }
}