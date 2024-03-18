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
import br.stimply.leagueinfo.core.domain.Resource
import br.stimply.leagueinfo.databinding.FragmentAccountBinding
import br.stimply.leagueinfo.feature_account.domain.model.Account
import br.stimply.leagueinfo.feature_static_data.data.remote.DataDragonAPI
import br.stimply.leagueinfo.feature_static_data.data.repository.AssetsRepositoryImpl
import br.stimply.leagueinfo.feature_static_data.data.repository.VersionManager
import br.stimply.leagueinfo.feature_static_data.domain.model.DataDragonLanguage
import br.stimply.leagueinfo.feature_static_data.domain.repository.AssetsRepository
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@AndroidEntryPoint
class AccountFragment : Fragment() {

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
            lifecycleScope.launch(Dispatchers.IO) {
                val api = Retrofit.Builder()
                    .baseUrl("https://ddragon.leagueoflegends.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DataDragonAPI::class.java)
                val repo: AssetsRepository = AssetsRepositoryImpl(api, VersionManager(api))
                repo.getChampionByName(DataDragonLanguage.BrazilianPortuguese, "Riven").collect {
                    when (it) {
                        is Resource.Success -> {
                            val icon = repo.getChampionIcon(it.data!!.image.name)
                            icon.collect { iconr ->
                                when (iconr) {
                                    is Resource.Success -> {
                                        withContext(Dispatchers.Main) {
                                            Glide.with(this@AccountFragment)
                                                .load(iconr.data)
                                                .into(binding.ivTest)
                                        }
                                    }
                                    is Resource.Error -> {

                                    }
                                    is Resource.Loading -> {

                                    }
                                }
                            }
                        }

                        is Resource.Error -> {
                            Timber.d(it.message)
                        }

                        is Resource.Loading -> {
                            if (it.loading) {
                                Timber.d("Loading")
                            } else {
                                Timber.d("Not Loading")
                            }
                        }
                    }
                }
            }
        }
        // test only
        updateEditText("baumhaus#0000")
    }

    private fun updateEditText(summonerName: String) {
        binding.edSummonerName.setText(summonerName)
        binding.edSummonerName.setSelection(summonerName.length)
    }

    private fun navigateIfAccount(account: Account?) {
        if (account == null) return
        Timber.d("account found $account")
    }

}