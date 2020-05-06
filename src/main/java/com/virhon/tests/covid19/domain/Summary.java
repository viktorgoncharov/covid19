package com.virhon.tests.covid19.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Summary")
@Table(name = "summary")
public class Summary {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("NewConfirmed")
    @Column(name = "new_confirmed")
    private Integer newConfirmed;
    @JsonProperty("TotalConfirmed")
    @Column(name = "total_confirmed")
    private Integer totalConfirmed;
    @JsonProperty("NewDeaths")
    @Column(name = "new_deaths")
    private Integer newDeaths;
    @JsonProperty("TotalDeaths")
    @Column(name = "total_deaths")
    private Integer totalDeaths;
    @JsonProperty("NewRecovered")
    @Column(name = "new_recovered")
    private Integer newRecovered;
    @JsonProperty("TotalRecovered")
    @Column(name = "total_recovered")
    private Integer totalRecovered;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "summary", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CountryCase> countries;

    public Summary() {
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CountryCase> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryCase> countries) {
        this.countries = countries;
    }
}
