package com.virhon.tests.covid19.stat;

import com.virhon.tests.covid19.dao.DataManager;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Component
public class StatEngine {
    final static Logger LOGGER = Logger.getLogger(StatEngine.class);
    @Autowired
    private DataManager dataManager;
    private Map<String, Value> values;
    private CovidSummaryCase csc;
    private StatBuilder builder;

    @PostConstruct
    public void setup() {
        final Optional<CovidSummaryCase> optionalCase = this.dataManager.getSummary();
        if (optionalCase.isPresent()) {
            this.csc = optionalCase.get();
        } else {
            this.csc = CovidSummaryCase.createEmpty();
            LOGGER.error("Unable to load summary data");
        }
        this.builder = new StatBuilder()
                .dataSource(this.csc)
                .value(new AffectedCountries(), new AffectedCountriesProcessor())
                .value(new GlobalRecoveryRate(), new GlobalRecoveryRateProcessor());
    }

    public Map<String, Value> calculate() throws Exception {
        return builder.build();
    }
}
