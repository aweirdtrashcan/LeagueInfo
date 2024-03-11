package br.stimply.leagueinfo.feature_account.data.remote

import br.stimply.leagueinfo.feature_account.data.model.AccountDto
import br.stimply.leagueinfo.feature_account.data.native.Native
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface AccountAPI {
    @GET("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    suspend fun getAccount(
        @Path("gameName") gameName: String,
        @Path("tagLine") tag: String,
        @Header("X-Riot-Token") apiKey: String = Native.getAccountApiKey()
    ): AccountDto
}