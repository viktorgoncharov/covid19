package com.virhon.tests.covid19.api;

import com.virhon.tests.covid19.Config;
import com.virhon.tests.covid19.dao.DataManager;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

@EnableJpaRepositories(basePackages = "com.virhon.tests.covid19.dao")
@EnableAutoConfiguration
@ComponentScan("com.virhon.tests.covid19")
@SpringBootTest(classes = {COVID19Client.class, Config.class, DataManager.class})
public class COVID19ClientTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private COVID19Client client;
    @Autowired
    private DataManager dataManager;

    @Test
    public void testSummaryReceiving() {
        final Optional<CovidSummaryCase> summary = client.getSummary();
        Assert.assertTrue(summary.isPresent());
        Assert.assertNotNull(summary.get().getGlobal().getTotalConfirmed());
    }

    @Test
    public void testReceivingStore() {
        // spring.jpa.hibernate.ddl-auto=create
        final Optional<CovidSummaryCase> summary = client.getSummary();
        Assert.assertTrue(summary.isPresent());
        dataManager.saveSummary(summary.get());
        Optional<CovidSummaryCase> gottenSummary = dataManager.getSummary();
        Assert.assertTrue(gottenSummary.isPresent());
        Assert.assertTrue(gottenSummary.get().getCountries().size() > 1);
    }
}