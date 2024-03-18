package br.stimply.leagueinfo.feature_profile.data.remote

import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_profile.data.model.SummonerDto
import br.stimply.leagueinfo.feature_profile.domain.util.SummonerRegion
import retrofit2.http.GET
import retrofit2.http.Url

abstract class SummonerAPI {
    @GET
    abstract suspend fun getSummoner(@Url url: String): SummonerDto

    companion object {
        private const val QUERY_URL: String = "lol/summoner/v4/summoners/by-puuid"

        fun createRequestUrl(region: SummonerRegion, account: Account): String {
            return "${region.url}/${QUERY_URL}/${account.puuid}"
        }
    }
}