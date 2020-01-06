package com.encurtador.msencurtadorurl.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EncurtadorUtilsTest {

    @Test
    void generateString() {
        final String urlCurta = EncurtadorUtils.generateString(7);

        Assert.assertEquals(7, urlCurta.length());
    }
}