package br.stimply.leagueinfo.feature_static_data.data.remote

import br.stimply.leagueinfo.feature_static_data.data.model.DataDragonVersion
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface DataDragonAPI {

    @GET("realms/{lang}.json")
    suspend fun getDataDragonVersion(
        @Path("lang") language: String
    ) : DataDragonVersion

    @GET("cdn/{version}/data/{lang}/champion/{champion}.json")
    suspend fun getChampionByName(
        @Path("lang") language: String,
        @Path("version") cdnVersion: String,
        @Path("champion") championName: String
    ): Map<String, Any>

    @GET("cdn/{version}/img/champion/{imageName}")
    suspend fun getChampionSquareImage(
        @Path("imageName") imageName: String,
        @Path("version") cdnVersion: String
    ): ResponseBody
}