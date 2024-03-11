package br.stimply.leagueinfo.core.data

import androidx.annotation.StringRes
import br.stimply.leagueinfo.App

class StringRes {
    companion object {
        fun getString(@StringRes resId: Int): String {
            return App.instance.getString(resId)
        }
    }
}