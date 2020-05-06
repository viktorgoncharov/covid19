package com.virhon.tests.covid19.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CountryCase")
@Table(name = "country_case")
public class CountryCase {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("Country")
    @Column(name = "country")
    private String country;
    @JsonProperty("CountryCode")
    @Column(name = "country_code")
    private String countryCode;
    @JsonProperty("Slug")
    @Column(name = "slug")
    private String slug;
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
    @JsonProperty("Date")
    @Column(name = "date_of", columnDefinition = "timestamp")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "summary_id", nullable = false)
    @JsonIgnore
    private Summary summary;

    public CountryCase() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
