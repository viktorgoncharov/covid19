package com.virhon.tests.covid19.stat;

import java.math.BigDecimal;

public abstract class Value {
    private String      code;
    private ValueType   type;
    private String      name;
    private BigDecimal  value;

    public Value(String code, ValueType type, String name) {
        this.code = code;
        this.type = type;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
