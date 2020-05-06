package com.virhon.tests.covid19.stat;

public class GlobalRecoveryRate extends Value {
    public GlobalRecoveryRate() {
        super("GLOBAL_RECOVERY_RATE", ValueType.RELATIVE,
                "The rate of total recovered by the total number of confirmed");
    }
}
