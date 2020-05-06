package com.virhon.tests.covid19.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "CovidCase")
@Table(name = "covid_case")
public class CovidCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @JsonProperty("Country")
    @Column(name = "country")
    private String country;
    @JsonProperty("CountryCode")
    @Column(name = "country_code")
    private String countryCode;
    @JsonProperty("Province")
    @Column(name = "province")
    private String province;
    @JsonProperty("City")
    @Column(name = "city")
    private String city;
    @JsonProperty("CityCode")
    @Column(name = "city_code")
    private String cityCode;
    @JsonProperty("Lat")
    @Column(name = "lat")
    private String lat;
    @JsonProperty("Lon")
    @Column(name = "lon")
    private String lon;
    @JsonProperty("Confirmed")
    @Column(name = "confirmed")
    private Integer confirmed;
    @JsonProperty("Deaths")
    @Column(name = "deaths")
    private Integer deaths;
    @JsonProperty("Recovered")
    @Column(name = "recovered")
    private Integer recovered;
    @JsonProperty("Active")
    @Column(name = "active")
    private Integer active;
    @JsonProperty("Date")
    @Column(name = "date_of", columnDefinition = "timestamp")
    private Date dateOf;

    public CovidCase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getDateOf() {
        return dateOf;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }
}
