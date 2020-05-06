package com.virhon.tests.covid19.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.virhon.tests.covid19.stat.DataSource;

import java.util.ArrayList;
import java.util.List;

public class CovidSummaryCase implements DataSource {
    @JsonProperty("Global")
    private Summary global;
    @JsonProperty("Countries")
    private List<CountryCase> countries;

    public static CovidSummaryCase createEmpty() {
        final CovidSummaryCase empty = new CovidSummaryCase();
        final Summary summary = new Summary();
        summary.setId(100L);
        summary.setNewRecovered(0);
        summary.setNewDeaths(0);
        summary.setNewConfirmed(0);
        summary.setTotalRecovered(0);
        summary.setTotalRecovered(0);
        summary.setTotalDeaths(0);
        summary.setTotalConfirmed(0);
        empty.setGlobal(summary);
        empty.setCountries(new ArrayList<>());
        return empty;
    }

    public Summary getGlobal() {
        return global;
    }

    public void setGlobal(Summary global) {
        this.global = global;
    }

    public List<CountryCase> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryCase> countries) {
        this.countries = countries;
    }
}
