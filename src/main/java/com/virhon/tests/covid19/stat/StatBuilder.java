package com.virhon.tests.covid19.stat;

import java.util.HashMap;
import java.util.Map;

public class StatBuilder {
    private DataSource dataSource;
    private Map<String, Value> values = new HashMap<>();
    private Map<String, Processor> processors = new HashMap<>();

    StatBuilder dataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    StatBuilder value(Value value, Processor processor) {
        this.values.put(value.getCode(), value);
        this.processors.put(value.getCode(), processor);
        return this;
    }

    Map<String, Value> build() throws Exception {
        if (this.dataSource == null) {
            throw new Exception("Undefined DataSource");
        }
        if (values.size() == 0) {
            throw new RuntimeException("No values to be calculated");
        }
        for (String key: values.keySet()) {
            final Value value = this.values.get(key);
            final Processor processor = this.processors.get(key);
            value.setValue(processor.calculateValue(this.dataSource).getValue());
        }
        return this.values;
    }
}
