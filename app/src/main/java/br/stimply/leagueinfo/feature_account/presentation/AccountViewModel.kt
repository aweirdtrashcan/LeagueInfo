package br.stimply.leagueinfo.feature_account.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.stimply.leagueinfo.feature_account.domain.use_cases.GetAccountUseCase
import br.stimply.leagueinfo.core.data.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getAccountUseCase: GetAccountUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AccountState())
    val state = _state.asStateFlow()

    fun onEvent(event: AccountEvent) {
        when (event) {
            is AccountEvent.OnSummonerChanged -> {
                _state.value = _state.value.copy(
                    summonerName = event.summoner
                )
            }
            is AccountEvent.OnSummonerSearch -> {
                searchAccount(_state.value.summonerName)
            }
            is AccountEvent.OnErrorDismissed -> {
                _state.value.errorList.removeFirst()
            }
        }
    }

    private fun searchAccount(summonerName: String) {
        viewModelScope.launch {
            getAccountUseCase(summonerName).collect {
                when (it) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            account = it.data
                        )
                        println(it.data)
                    }
                    is Resource.Error -> {
                        _state.value.errorList.add(it.message!!)
                        println("Error: ${it.message}")
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = it.loading
                        )
                    }
                }
            }
        }
    }

}