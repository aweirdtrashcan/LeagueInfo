package br.stimply.leagueinfo.feature_profile.presentation

import androidx.lifecycle.ViewModel
import br.stimply.leagueinfo.feature_profile.domain.use_cases.GetSummonerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getSummonerUseCase: GetSummonerUseCase
) : ViewModel() {



}