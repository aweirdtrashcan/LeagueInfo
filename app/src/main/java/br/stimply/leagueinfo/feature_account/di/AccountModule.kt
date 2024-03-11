package br.stimply.leagueinfo.feature_account.di

import br.stimply.leagueinfo.feature_account.data.remote.AccountAPI
import br.stimply.leagueinfo.feature_account.data.repository.AccountRepositoryImpl
import br.stimply.leagueinfo.feature_account.domain.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountModule {

    @Provides
    @Singleton
    fun provideAccountRepository(api: AccountAPI): AccountRepository {
        return AccountRepositoryImpl(api)
    }
}