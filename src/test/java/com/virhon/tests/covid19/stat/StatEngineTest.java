package com.virhon.tests.covid19.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@SpringBootTest
public class StatEngineTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private StatEngine engine;

    @Test
    void testEngine() throws Exception {
        final Map<String,Value> values = this.engine.calculate();
        Assert.assertFalse(values.isEmpty());
    }
}