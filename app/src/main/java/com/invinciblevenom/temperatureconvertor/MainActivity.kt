package com.invinciblevenom.temperatureconvertor

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var celsiusEditText: EditText
    private lateinit var convertButton: Button
    private lateinit var fahrenheitTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        celsiusEditText = findViewById(R.id.celsiusEditText)
        convertButton = findViewById(R.id.convertButton)
        fahrenheitTextView = findViewById(R.id.fahrenheitTextView)

        convertButton.isEnabled = false

        celsiusEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not used
            }

            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().trim()
                convertButton.isEnabled = input.isNotEmpty()
            }
        })

        convertButton.setOnClickListener {
            val celsius = celsiusEditText.text.toString().toDouble()
            val fahrenheit = convertCelsiusToFahrenheit(celsius)
            fahrenheitTextView.text = getString(R.string.fahrenheit_result, fahrenheit)
        }
    }

    private fun convertCelsiusToFahrenheit(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }
}
