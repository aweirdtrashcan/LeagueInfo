package br.stimply.leagueinfo.feature_profile.di

import br.stimply.leagueinfo.feature_profile.data.remote.SummonerAPI
import br.stimply.leagueinfo.feature_profile.data.repository.SummonerRepositoryImpl
import br.stimply.leagueinfo.feature_profile.domain.repository.SummonerRepository
import br.stimply.leagueinfo.feature_profile.domain.use_cases.GetSummonerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object ProfileModule {

    @Provides
    @ViewModelScoped
    fun provideSummonerApi(): SummonerAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SummonerAPI::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideSummonerRepository(api: SummonerAPI): SummonerRepository {
        return SummonerRepositoryImpl(api)
    }

    @Provides
    @ViewModelScoped
    fun provideUseCases(repository: SummonerRepository): GetSummonerUseCase {
        return GetSummonerUseCase(repository)
    }
}
