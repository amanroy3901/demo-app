package com.example.demo_app

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CalclulatorTest {

    @Test
    fun evaluatesSimpleExpressionsCorrectly() {
        assertEquals(10.0, Calculator().evaluateExpression("1 + 9"), 0.001)
        assertEquals(5.0, Calculator().evaluateExpression("10 - 5"), 0.001)
        assertEquals(20.0, Calculator().evaluateExpression("2 * 10"), 0.001)
        assertEquals(5.0, Calculator().evaluateExpression("10 / 2"), 0.001)
    }

    @Test
    fun throwsExceptionForInvalidExpressions() {
        assertThrows(RuntimeException::class.java) {
            Calculator().evaluateExpression("1 +")
        }
        assertThrows(RuntimeException::class.java) {
            Calculator().evaluateExpression("1 + 9 )")
        }
        assertThrows(RuntimeException::class.java) {
            Calculator().evaluateExpression("1 + 9 /")
        }
    }

}