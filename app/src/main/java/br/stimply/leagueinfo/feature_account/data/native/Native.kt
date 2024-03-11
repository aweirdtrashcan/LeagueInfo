package br.stimply.leagueinfo.feature_account.data.native

object Native {

    private var isLoaded = false

    fun loadNative() {
        if (!isLoaded) {
            System.loadLibrary("leagueinfo")
            isLoaded = true
        }
    }

    external fun getAccountApiKey(): String
}