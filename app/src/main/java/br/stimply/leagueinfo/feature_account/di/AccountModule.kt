package br.stimply.leagueinfo.feature_account.di

import br.stimply.leagueinfo.feature_account.data.remote.AccountAPI
import br.stimply.leagueinfo.feature_account.data.repository.AccountRepositoryImpl
import br.stimply.leagueinfo.feature_account.domain.repository.AccountRepository
import br.stimply.leagueinfo.feature_account.domain.use_cases.GetAccountUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AccountModule {

    @Provides
    @ViewModelScoped
    fun provideAccountRepository(api: AccountAPI): AccountRepository {
        return AccountRepositoryImpl(api)
    }

    @Provides
    @ViewModelScoped
    fun provideAccountApi(): AccountAPI {
        return Retrofit.Builder()
            .baseUrl("https://americas.api.riotgames.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(AccountAPI::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAccountUseCase(repository: AccountRepository): GetAccountUseCase {
        return GetAccountUseCase(repository)
    }
}