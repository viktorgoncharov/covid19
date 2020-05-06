package com.virhon.tests.covid19.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CovidSummaryCase {
    @JsonProperty("Global")
    private Summary global;
    @JsonProperty("Countries")
    private List<CountryCase> countries;

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
