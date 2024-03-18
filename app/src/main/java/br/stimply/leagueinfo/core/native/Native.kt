package br.stimply.leagueinfo.core.native

object Native {

    private var isLoaded = false

    fun loadNative() {
        if (!isLoaded) {
            System.loadLibrary("leagueinfo")
            isLoaded = true
        }
    }

    external fun getRiotApiKey(): String
}