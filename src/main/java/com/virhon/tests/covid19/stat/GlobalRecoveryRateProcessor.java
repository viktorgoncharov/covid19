package com.virhon.tests.covid19.stat;

import com.virhon.tests.covid19.domain.Summary;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlobalRecoveryRateProcessor implements Processor {
    @Override
    public Value calculateValue(DataSource dataSource) {
        final GlobalRecoveryRate value = new GlobalRecoveryRate();
        final Summary summary = dataSource.getGlobal();
        final BigDecimal totalRecovered = new BigDecimal(summary.getTotalRecovered());
        final BigDecimal totalConfirmed = new BigDecimal(summary.getTotalConfirmed());
        value.setValue(totalRecovered.divide(totalConfirmed, 2, RoundingMode.HALF_UP));
        return value;
    }
}
