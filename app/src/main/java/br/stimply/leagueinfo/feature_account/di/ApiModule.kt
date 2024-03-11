package br.stimply.leagueinfo.feature_account.di

import br.stimply.leagueinfo.feature_account.data.remote.AccountAPI
import br.stimply.leagueinfo.feature_account.domain.util.AccountRegion
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideAccountApi(): AccountAPI {
        return Retrofit.Builder()
            .baseUrl(AccountRegion.Americas.url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(AccountAPI::class.java)
    }
}