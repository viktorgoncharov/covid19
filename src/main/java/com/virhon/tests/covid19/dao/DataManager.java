package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.CountryCase;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import com.virhon.tests.covid19.domain.Summary;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class DataManager {
    final static Logger LOGGER = Logger.getLogger(DataManager.class);
    public static final long SUMMARY_ID = 100L;
    public static final int BATCH_SIZE = 100;
    @Autowired
    private SummaryRepository summaryRepository;
    @Autowired
    private CountryCaseRepository countryCaseRepository;

    /**
     *
     * @param covidSummaryCase       the object need to be stored
     * @return                       generated id of stored object
     */
    public CovidSummaryCase saveSummary(CovidSummaryCase covidSummaryCase) {
        final Summary summary = covidSummaryCase.getGlobal();
        summary.setId(SUMMARY_ID);
        final List<CountryCase> cases = covidSummaryCase.getCountries();
        for (int i=0;i<cases.size();i++) {
            final CountryCase cCase = cases.get(i);
            cCase.setId(1000L + Long.valueOf(i));
            cCase.setSummary(summary);
        }
        this.countryCaseRepository.saveAll(cases);
        this.countryCaseRepository.flush();
        return covidSummaryCase;
    }

    public Optional<CovidSummaryCase> getSummary() {
        final Long id = this.SUMMARY_ID;
        final CovidSummaryCase covidSummaryCase = new CovidSummaryCase();
        final Optional<Summary> summary = this.summaryRepository.findById(id);
        if (!summary.isPresent()) {
            return Optional.empty();
        }
        covidSummaryCase.setGlobal(summary.get());
        covidSummaryCase.setCountries(summary.get().getCountries());
        return Optional.of(covidSummaryCase);
    }
}
