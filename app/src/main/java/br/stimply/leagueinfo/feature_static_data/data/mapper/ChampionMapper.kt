package br.stimply.leagueinfo.feature_static_data.data.mapper

import br.stimply.leagueinfo.feature_static_data.data.model.ChampionDto
import br.stimply.leagueinfo.feature_static_data.data.model.ChampionInfoDto
import br.stimply.leagueinfo.feature_static_data.data.model.ImageDto
import br.stimply.leagueinfo.feature_static_data.data.model.SkinsDto
import br.stimply.leagueinfo.feature_static_data.data.model.SpellsDto
import br.stimply.leagueinfo.feature_static_data.domain.model.Champion
import br.stimply.leagueinfo.feature_static_data.domain.model.ChampionInfo
import br.stimply.leagueinfo.feature_static_data.domain.model.Image
import br.stimply.leagueinfo.feature_static_data.domain.model.Skin
import br.stimply.leagueinfo.feature_static_data.domain.model.Spell

fun ChampionDto.toChampion(): Champion {
    return Champion(
        name = this.name,
        title = this.title,
        image = this.image.toImage(),
        skins = this.skins.map { it.toSkin() },
        lore = this.lore,
        tags = this.tags,
        costType = this.parType,
        info = this.info.toChampionInfo(),
        spells = this.spells.map { it.toSpell() }
    )
}

fun ImageDto.toImage(): Image {
    return Image(
        name = this.full,
        sprite = this.sprite,
        Image.Dimensions(
            this.x,
            this.y,
            this.w,
            this.h
        )
    )
}

fun SkinsDto.toSkin(): Skin {
    return Skin(
        id = this.id,
        skinIndex = this.num,
        name = this.name,
        chromas = this.chromas
    )
}

fun ChampionInfoDto.toChampionInfo(): ChampionInfo {
    return ChampionInfo(
        attack = attack,
        defense = defense,
        magic = magic,
        difficulty = difficulty
    )
}

fun SpellsDto.toSpell(): Spell {
    return Spell(
        name = this.name,
        description = this.description,
        image = this.image.toImage()
    )
}