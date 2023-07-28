package com.example.demo_app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.display)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        val currentValue = display.text.toString()
        val newValue = if (currentValue == "0" || currentValue.length >= 1) {
            currentValue + button.text.toString()
        } else if (lastNumeric) {
            currentValue + button.text.toString()
        } else {
            button.text.toString()
        }
        display.text = newValue
        lastNumeric = true
    }

    fun onDecimalClick(view: View) {
        if (lastNumeric && !lastDot) {
            display.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperatorClick(view: View) {
        if (lastNumeric && !isOperatorAdded(display.text.toString())) {
            display.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }


    fun onEqualClick(view: View) {
        if (lastNumeric) {
            try {
                val expression = ExpressionBuilder(display.text.toString()).build()
                val result = expression.evaluate()
                display.text = result.toString()
            } catch (ex: Exception) {
                display.text = "Error"
            }
            lastDot = false
            lastNumeric = true
        }
    }

    fun onCancelClick(view: View) {
        display.text = "0"
        lastNumeric = false
        lastDot = false
    }

    private fun isOperatorAdded(value: String): Boolean {
        return value.endsWith("+") || value.endsWith("-") || value.endsWith("*") || value.endsWith("/")
    }

}
