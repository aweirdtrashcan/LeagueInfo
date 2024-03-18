package br.stimply.leagueinfo.feature_static_data.domain.model

data class Champion(
    val name: String,
    val title: String,
    val image: Image,
    val skins: List<Skin>,
    val lore: String,
    val tags: List<String>,
    val costType: String,
    val info: ChampionInfo,
    val spells: List<Spell>
)
