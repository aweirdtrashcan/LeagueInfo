package br.stimply.leagueinfo.feature_static_data.data.repository

import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.feature_static_data.data.mapper.toChampion
import br.stimply.leagueinfo.feature_static_data.data.model.ChampionDto
import br.stimply.leagueinfo.feature_static_data.data.remote.DataDragonAPI
import br.stimply.leagueinfo.feature_static_data.domain.model.Champion
import br.stimply.leagueinfo.feature_static_data.domain.model.DataDragonLanguage
import br.stimply.leagueinfo.feature_static_data.domain.repository.AssetsRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class AssetsRepositoryImpl(
    private val api: DataDragonAPI,
    private val versionManager: VersionManager
) : AssetsRepository {

    override suspend fun getChampionByName(
        language: DataDragonLanguage,
        championName: String
    ): Flow<Resource<Champion>> {
        return flow {
            emit(Resource.Loading(true))

            val champion = try {
                val version = versionManager.getVersion("br")
                val remote = api.getChampionByName(language.language, version, championName)
                var deserializedChampion: ChampionDto? = null
                val gson = Gson()
                var champion: ChampionDto? = null

                remote["data"]?.let {
                    if (it is Map<*, *>) {
                        for ((key, value) in it) {
                            if (value is Map<*, *>) {
                                deserializedChampion =
                                    gson.fromJson(gson.toJson(value), ChampionDto::class.java)

                                if (deserializedChampion != null)
                                    break
                            }
                        }
                    }
                }
                deserializedChampion
            } catch (e: HttpException) {
                Timber.d("Http Exception(${e.code()}): ${e.message()}")
                null
            } catch (e: VersionNotFoundException) {
                Timber.d("Unable to find a version for DataDragon")
                null
            } catch (e: Exception) {
                Timber.d("Unknown exception: ${e.message}")
                null
            }

            if (champion == null) {
                emit(Resource.Error("Failed to get Assets from internet"))
                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Success(champion.toChampion()))
            emit(Resource.Loading(false))
        }
    }

    override suspend fun getAllChampions(language: DataDragonLanguage): Flow<Resource<List<Champion>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getChampionIcon(imageName: String): Flow<Resource<ByteArray>> {
        return flow {
            emit(Resource.Loading(true))

            val icon = try {
                val version = versionManager.getVersion("br")
                val remote = api.getChampionSquareImage(imageName, version)
                remote.bytes()
            } catch (e: HttpException) {
                Timber.d("Http Exception(${e.code()}): ${e.message()}")
                null
            } catch (e: VersionNotFoundException) {
                Timber.d(e.message)
                null
            } catch (e: Exception) {
                Timber.d("Unknown exception: ${e.message}")
                null
            }

            if (icon == null) {
                emit(Resource.Error("Error getting champion icon."))
                emit(Resource.Loading(false))
                return@flow
            }

            emit(Resource.Success(icon))
            emit(Resource.Loading(false))
        }
    }
}