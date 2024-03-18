package br.stimply.leagueinfo.feature_static_data.data.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChampionVarDto {

    @SerializedName("key")
    private final String key;
    @SerializedName("link")
    private final String link;
    @SerializedName("coeff")
    private final List<Float> coeff;

    public ChampionVarDto(@NonNull String key, @NonNull String link, @NonNull List<Float> coeff) {
        this.key = key;
        this.link = link;
        this.coeff = coeff;
    }

    @NonNull
    public String getKey() {
        return key;
    }

    @NonNull
    public String getLink() {
        return link;
    }

    @NonNull
    public List<Float> getCoeff() {
        return coeff;
    }
}
