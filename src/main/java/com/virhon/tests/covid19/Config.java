package com.virhon.tests.covid19;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories
public class Config {
    @Value("${all_data_url}")
    private String allDataUrl;

    @Value("${summary_url}")
    private String summaryUrl;

    public String getAllDataUrl() {
        return this.allDataUrl;
    }

    public String getSummaryUrl() {
        return this.summaryUrl;
    }
}
