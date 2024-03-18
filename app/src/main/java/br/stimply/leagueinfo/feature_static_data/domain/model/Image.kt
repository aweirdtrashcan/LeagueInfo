package br.stimply.leagueinfo.feature_static_data.domain.model

data class Image(
    val name: String,
    val sprite: String,
    val dimensions: Dimensions
) {
    data class Dimensions(
        val x: Int,
        val y: Int,
        val width: Int,
        val height: Int
    )
}
