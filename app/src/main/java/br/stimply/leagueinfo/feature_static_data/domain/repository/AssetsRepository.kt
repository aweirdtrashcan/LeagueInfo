package br.stimply.leagueinfo.feature_static_data.domain.repository

import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.feature_static_data.domain.model.Champion
import br.stimply.leagueinfo.feature_static_data.domain.model.DataDragonLanguage
import kotlinx.coroutines.flow.Flow

interface AssetsRepository {

    suspend fun getChampionByName(
        language: DataDragonLanguage,
        championName: String
    ): Flow<Resource<Champion>>

    suspend fun getAllChampions(
        language: DataDragonLanguage
    ): Flow<Resource<List<Champion>>>

    suspend fun getChampionIcon(
        imageName: String
    ): Flow<Resource<ByteArray>>
}