package br.stimply.leagueinfo.feature_account.data.repository

import android.content.res.Resources
import br.stimply.leagueinfo.R
import br.stimply.leagueinfo.feature_account.data.mapper.toAccount
import br.stimply.leagueinfo.feature_account.data.native.Native
import br.stimply.leagueinfo.feature_account.data.remote.AccountAPI
import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_account.domain.repository.AccountRepository
import br.stimply.leagueinfo.core.data.Resource
import br.stimply.leagueinfo.core.data.StringRes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountAPI: AccountAPI
) : AccountRepository {

    override suspend fun getAccount(gameName: String, tagLine: String): Flow<Resource<Account>> {
        Native.loadNative()
        return withContext(Dispatchers.IO) {
            flow {
                emit(Resource.Loading(true))
                if (gameName.isBlank() || tagLine.isBlank()) {
                    val errorMessage = StringRes.getString(R.string.error_invalid_summoner)
                    emit(Resource.Error(errorMessage))
                    return@flow
                }
                println("repository called: $gameName $tagLine")
                try {
                    val remoteAccount = accountAPI.getAccount(gameName, tagLine)
                    emit(Resource.Success(remoteAccount.toAccount()))
                } catch (e: HttpException) {
                    emit(Resource.Error("Failed to get account: ${e.code()} ${e.message()}"))
                    return@flow
                } catch (e : IOException) {
                    emit(Resource.Error("Failed to get account. ${e.message}"))
                    emit(Resource.Loading(false))
                    return@flow
                }

            }
        }
    }

}