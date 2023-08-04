package com.example.demo_app

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {

    fun evaluateExpression(expression: String): Double {
        try {
            val expressionBuilder = ExpressionBuilder(expression)
            return expressionBuilder.build().evaluate()
        } catch (ex: Exception) {
            throw RuntimeException("Invalid expression: $expression")
        }
    }
}
