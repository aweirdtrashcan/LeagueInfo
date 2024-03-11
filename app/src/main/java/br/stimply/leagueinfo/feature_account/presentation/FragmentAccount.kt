package br.stimply.leagueinfo.feature_account.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.stimply.leagueinfo.databinding.FragmentAccountBinding
import br.stimply.leagueinfo.feature_account.domain.model.Account
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentAccount : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    private val viewModel by viewModels<AccountViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    navigateIfAccount(state.account)
                    updateEditText(state.summonerName)
                }
            }
        }
        binding.edSummonerName.addTextChangedListener {
            viewModel.onEvent(AccountEvent.OnSummonerChanged(it.toString()))
        }
        binding.btnSearch.setOnClickListener {
            viewModel.onEvent(AccountEvent.OnSummonerSearch)
        }
    }

    private fun updateEditText(summonerName: String) {
        binding.edSummonerName.setText(summonerName)
        binding.edSummonerName.setSelection(summonerName.length)
    }

    private fun navigateIfAccount(account: Account?) {
        if (account == null) return
        println(account.puuid)
    }

}