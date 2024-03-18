package br.stimply.leagueinfo.feature_static_data.data.repository;

import android.content.res.Resources.NotFoundException
import br.stimply.leagueinfo.feature_static_data.data.model.DataDragonVersion
import br.stimply.leagueinfo.feature_static_data.data.remote.DataDragonAPI

class VersionManager(
    private val api: DataDragonAPI
) {

    private val versions = hashMapOf<String, DataDragonVersion>()

    suspend fun getVersion(region: String): String {
        return if (versions[region] != null) {
            versions[region]!!.v
        } else {
            versions[region] = api.getDataDragonVersion(region)
            if (versions[region] == null) {
                throw VersionNotFoundException(region)
            }
            versions[region]!!.v
        }
    }
}

class VersionNotFoundException(region: String):
    NotFoundException("Unable to find Version for region $region")