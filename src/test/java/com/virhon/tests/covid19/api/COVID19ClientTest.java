package com.virhon.tests.covid19.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.virhon.tests.covid19.Config;
import com.virhon.tests.covid19.common.Tool;
import com.virhon.tests.covid19.dao.DataManager;
import com.virhon.tests.covid19.domain.CovidCase;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import com.virhon.tests.covid19.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
    public void testDataReceiving() {
        final List<CovidCase> result = client.receiveAllCases();
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void testSummaryReceiving() {
        final Optional<CovidSummaryCase> summary = client.getSummary();
        Assert.assertTrue(summary.isPresent());
        Assert.assertNotNull(summary.get().getGlobal().getTotalConfirmed());
    }

    @Test
    public void testReceivingStore() {
        final Optional<CovidSummaryCase> summary = client.getSummary();
        Assert.assertTrue(summary.isPresent());
        dataManager.saveSummary(summary.get());
        Optional<Summary> gottenSummary = dataManager.getSummary();
        Assert.assertTrue(gottenSummary.isPresent());
        Assert.assertTrue(gottenSummary.get().getCountries().size() > 1);
    }

    @Test
    void testAllDataReceiving() {
        List<CovidCase> cases = client.receiveAllCases();
        cases = this.dataManager.saveAllCases(cases);
        cases = this.dataManager.readAllByDate(cases.get(0).getDateOf());
        Assert.assertTrue(cases.size() > 1);
    }

    @Test
    void testAllDataReceivingFromFile() throws IOException {
        Type casesListType = new TypeToken<ArrayList<CovidCase>>() {}.getType();
        final String data = Tool.readFile("covid19-short.json");
        final List<CovidCase> cases = new ObjectMapper().readValue(data, new TypeReference<List<CovidCase>>(){});
        final List<CovidCase> saved = this.dataManager.saveAllCases(cases);
        final List<CovidCase> given = this.dataManager.readAllByDate(cases.get(0).getDateOf());
        Assert.assertTrue(cases.size() > 1);
    }
}