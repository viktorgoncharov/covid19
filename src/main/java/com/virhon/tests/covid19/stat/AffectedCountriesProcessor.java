package com.virhon.tests.covid19.stat;

import java.math.BigDecimal;

public class AffectedCountriesProcessor implements Processor {
    @Override
    public Value calculateValue(DataSource dataSource) {
        final AffectedCountries value = new AffectedCountries();
        value.setValue(new BigDecimal(dataSource.getCountries().stream()
                .filter(c -> c.getTotalConfirmed().equals(0)).count()));
        return value;
    }
}
