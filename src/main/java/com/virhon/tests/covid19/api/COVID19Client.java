package com.virhon.tests.covid19.api;

import com.virhon.tests.covid19.Config;
import com.virhon.tests.covid19.domain.CovidSummaryCase;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Component
public class COVID19Client {
    @Autowired
    private Config config;
    final static Logger LOGGER = Logger.getLogger(COVID19Client.class);
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<String>(headers);
    RestTemplate restTemplate = new RestTemplate();

    public Optional<CovidSummaryCase> getSummary() {
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            ResponseEntity<CovidSummaryCase> response = restTemplate.getForEntity(config.getSummaryUrl(),
                    CovidSummaryCase.class);
            if (response.getBody() == null) {
                throw new Exception("Summary not found");
            } else {
                return Optional.of(response.getBody());
            }
        } catch (Exception e) {
            LOGGER.error("Summary from COVID-19 API can't be received. Cause: ".concat(e.getMessage()));
            return Optional.empty();
        }
    }
}
