/*******************************************************************************
 * Copyright 2016 Capital One Services, LLC and Bitwise, Inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package hydrograph.engine.transformation.standardfunctions;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * The Class StringFunctionTest.
 *
 * @author Bitwise
 */

public class StringFunctionTest {

    @Test
    public void testNumericLeftPadding() {
        String actual = StringFunctions.numericLeftPad(9999999, 10, '*');
        Assert.assertEquals(actual, "***9999999");
    }

    @Test
    public void testNumericLeftPadOnInteger() {
        String actual = StringFunctions.numericLeftPad(9999999, 10, '*');
        Assert.assertEquals(actual, "***9999999");
    }

    @Test
    public void testNumericLeftPadOnIntegerInputSizeEqualsRequiredSize() {
        String actual = StringFunctions.numericLeftPad(999999, 6, '*');
        Assert.assertEquals(actual, "999999");
    }

    @Test
    public void testNumericLeftPadOnIntegerNegativeInteger() {
        String actual = StringFunctions.numericLeftPad(-999999, 10, '0');
        Assert.assertEquals(actual, "-000999999");
    }

    @Test
    public void testNumericRightPadding() {
        String actual = StringFunctions.numericRightPad(99999, 10, '*');
        Assert.assertEquals(actual, "99999*****");
    }

    @Test
    public void testNumericRightPadOnInteger() {
        String actual = StringFunctions.numericRightPad(9999999, 10, '*');
        Assert.assertEquals(actual, "9999999***");
    }

    @Test
    public void testNumericRightPadOnIntegerInputSizeEqualsRequiredSize() {
        String actual = StringFunctions.numericRightPad(999999, 6, '*');
        Assert.assertEquals(actual, "999999");
    }

    @Test
    public void testNumericRightPadOnIntegerNegativeInteger() {
        String actual = StringFunctions.numericRightPad(-999999, 10, '#');
        Assert.assertEquals(actual, "-999999###");
    }


    @Test
    public void testNumericString() {
        boolean result1 = StringFunctions.isNumeric("abcds");
        boolean result2 = StringFunctions.isNumeric("sneha123");
        boolean result3 = StringFunctions.isNumeric("12345");
        boolean result4 = StringFunctions.isNumeric("0000");
        Assert.assertEquals(result1, false);
        Assert.assertEquals(result2, false);
        Assert.assertEquals(result3, true);
        Assert.assertEquals(result4, true);
    }

    @Test
    public void testAlphabeticString() {
        boolean result1 = StringFunctions.isAlphabetic("abcds");
        boolean result2 = StringFunctions.isAlphabetic("sneha123");
        boolean result3 = StringFunctions.isAlphabetic("12345");
        boolean result4 = StringFunctions.isAlphabetic("0000");
        Assert.assertEquals(result1, true);
        Assert.assertEquals(result2, false);
        Assert.assertEquals(result3, false);
        Assert.assertEquals(result4, false);
    }

    @Test
    public void testStringToHexCoversion() {
        String result1 = StringFunctions.toHex("abc");
        String result2 = StringFunctions.toHex("ABC");
        String result3 = StringFunctions.toHex("0123");
        Assert.assertEquals(result1, "616263");
        Assert.assertEquals(result2, "414243");
        Assert.assertEquals(result3, "30313233");
    }

    @Test
    public void testStringStartsWith() {
        boolean result1 = StringFunctions.startsWith("abc", "a");
        boolean result2 = StringFunctions.startsWith("$12131231", "$1213");
        boolean result3 = StringFunctions.startsWith("a12312ada", "a21");
        Assert.assertEquals(result1, true);
        Assert.assertEquals(result2, true);
        Assert.assertEquals(result3, false);
    }

    @Test
    public void testStringToChar() {
        String resultShort = StringFunctions.toChar((short) 10);
        String resultInteger = StringFunctions.toChar(10);
        String resultLong = StringFunctions.toChar(10L);
        String resultFloat = StringFunctions.toChar(10.1f);
        String resultDouble = StringFunctions.toChar(10.121);
        String resultBigDecimal1 = StringFunctions.toChar(new BigDecimal(121.23).setScale(2, BigDecimal.ROUND_DOWN));
        String resultBigDecimal2 = StringFunctions.toChar(new BigDecimal(5646754.453), 2);

        Assert.assertEquals(resultShort, "10");
        Assert.assertEquals(resultInteger, "10");
        Assert.assertEquals(resultLong, "10");
        Assert.assertEquals(resultFloat, "10.1");
        Assert.assertEquals(resultDouble, "10.121");
        Assert.assertEquals(resultBigDecimal1, "121.23");
        Assert.assertEquals(resultBigDecimal2, "5646754.45");
    }

}
