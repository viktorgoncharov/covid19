package com.virhon.tests.covid19.dao;

import com.virhon.tests.covid19.domain.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataManager {
    final static Logger LOGGER = Logger.getLogger(DataManager.class);
    public static final long SUMMARY_ID = 100L;
    public static final int BATCH_SIZE = 100;
    @Autowired
    private SummaryRepository summaryRepository;
    @Autowired
    private CountryCaseRepository countryCaseRepository;
    @Autowired
    private CovidCaseRepository covidCaseRepository;

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

    public Optional<Summary> getSummary() {
        final Long id = this.SUMMARY_ID;
        final CovidSummaryCase covidSummaryCase = new CovidSummaryCase();
        return this.summaryRepository.findById(id);
    }

    public List<CovidCase> saveAllCases(List<CovidCase> cases) {
        final List<CovidCase> result = new ArrayList<>();
        for (Integer i=0;i<cases.size();) {
            LOGGER.info("Saving batch started from ".concat(i.toString()));
            final int to;
            if (i+BATCH_SIZE < cases.size()) {
                to = i+BATCH_SIZE;
            } else {
                to = cases.size();
            }
            final List<CovidCase> subList = cases.subList(i, to);
            this.covidCaseRepository.saveAll(subList);
            result.addAll(subList);
            i+=BATCH_SIZE;
        }
        return result;
    }

    public List<CovidCase> readAllByDate(Date date) {
        return this.covidCaseRepository.findAllByDateOf(date);
    }
}
