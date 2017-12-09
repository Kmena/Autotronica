package eu.chargetime.ocpp.model.test;

import eu.chargetime.ocpp.model.core.ResetRequest;
import eu.chargetime.ocpp.model.core.ResetType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * MIT License
 *
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ResetRequestTest {
    ResetRequest request;

    @Before
    public void setUp() throws Exception {
        request = new ResetRequest();
    }


    @Test
    public void setType_resetType_typeIsSet() throws Exception {
        // Given
        ResetType resetType = ResetType.Hard;

        // When
        request.setType(resetType);

        // Then
        assertThat(request.objType(), equalTo(resetType));
    }


    @Test
    public void validate_returnFalse() {
        // When
        boolean isValid = request.validate();

        // Then
        assertThat(isValid, is(false));
    }

    @Test
    public void validate_typeIsSet_returnTrue() throws Exception {
        // Given
        request.setType(ResetType.Hard);

        // When
        boolean isValid = request.validate();

        // Then
        assertThat(isValid, is(true));
    }

    @Test
    public void isTransactionRelated_returnsFalse() {
        // When
        boolean isTransactionRelated = request.transactionRelated();

        // Then
        assertThat(isTransactionRelated, is(false));
    }
}