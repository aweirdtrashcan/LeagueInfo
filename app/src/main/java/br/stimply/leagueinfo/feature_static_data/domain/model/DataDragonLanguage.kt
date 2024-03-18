package br.stimply.leagueinfo.feature_static_data.domain.model

sealed class DataDragonLanguage(val language: String) {
    data object BrazilianPortuguese : DataDragonLanguage("pt_BR")
    data object AmericanEnglish : DataDragonLanguage("en_US")
}