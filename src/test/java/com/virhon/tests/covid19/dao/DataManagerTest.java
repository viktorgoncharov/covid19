package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.CountryCase;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import com.virhon.tests.covid19.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.virhon.tests.covid19")
@EnableAutoConfiguration
@ComponentScan("com.virhon.tests.covid19.dao")
@EntityScan(value = "com.virhon.tests.covid19.domain")
@SpringBootTest(classes = {DataManager.class})
public class DataManagerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private DataManager dataManager;

    @Test
    void testSummaryRepo() {
        final Summary summary = new Summary();
        summary.setTotalConfirmed(7);
        summary.setTotalDeaths(0);
        summary.setTotalRecovered(7);
        summary.setNewConfirmed(1);
        summary.setNewDeaths(0);
        summary.setNewRecovered(4);
        final CountryCase countryCase = new CountryCase();
        countryCase.setSummary(summary);
        countryCase.setCountry("ALABABA");
        countryCase.setCountryCode("ALA");
        countryCase.setDate(new Date());
        countryCase.setNewConfirmed(10);
        countryCase.setNewDeaths(3);
        countryCase.setNewRecovered(5);
        countryCase.setSlug("slug");
        countryCase.setTotalConfirmed(100);
        countryCase.setTotalDeaths(0);
        countryCase.setTotalRecovered(90);
        CovidSummaryCase csCase = new CovidSummaryCase();
        csCase.setGlobal(summary);
        csCase.setCountries(Arrays.asList(countryCase));
        csCase = this.dataManager.saveSummary(csCase);
        final Long id = summary.getId();
        final Optional<CovidSummaryCase> gotten = this.dataManager.getSummary();
        Assert.assertTrue(gotten.isPresent());
        Assert.assertEquals(gotten.get().getGlobal().getId(), id);
        Assert.assertEquals(gotten.get().getGlobal().getTotalDeaths(), Integer.valueOf(0));
    }
}