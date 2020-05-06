package com.virhon.tests.covid19.stat;

import com.virhon.tests.covid19.domain.CountryCase;
import com.virhon.tests.covid19.domain.Summary;

import java.util.List;

public interface DataSource {
    Summary getGlobal();
    List<CountryCase> getCountries();
}
