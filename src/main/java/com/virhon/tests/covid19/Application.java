package com.virhon.tests.covid19;

import com.virhon.tests.covid19.api.COVID19Client;
import com.virhon.tests.covid19.dao.DataManager;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import com.virhon.tests.covid19.stat.StatEngine;
import com.virhon.tests.covid19.stat.Value;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@EntityScan(value = "com.virhon.tests.covid19.domain")
@SpringBootApplication
public class Application {
    final static Logger LOGGER = Logger.getLogger(COVID19Client.class);
    @Autowired
    private COVID19Client client;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private StatEngine engine;

    private Map<String, Value> values;

    @PostConstruct
    void setup() throws Exception {
        LOGGER.info("Trying to receive the data from COVID-19 open API...");
        final Optional<CovidSummaryCase> summary = client.getSummary();
        LOGGER.info("OK");
        LOGGER.info("Save data locally...");
        this.dataManager.saveSummary(summary.get());
        LOGGER.info("OK");
        LOGGER.info("Trying to calculate the values...");
        values = this.engine.calculate();
        LOGGER.info("OK");
    }

    private void printValues() {
        System.out.println("=================================================================================================================");
        System.out.println(" VALUES                                                                                                         =");
        System.out.println("=================================================================================================================");
        System.out.println(" Code                    Type            Name                                                         Value      ");
        System.out.println("----------------------- --------------- ------------------------------------------------------------ ------------");
        for (String key: values.keySet()) {
            final Value value = values.get(key);
            final String line = String.format("%23s %15s %60s %12s", key, value.getType().toString(),
                    value.getName(), value.getValue().toString());
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        context.getBean(Application.class).printValues();
    }
}
