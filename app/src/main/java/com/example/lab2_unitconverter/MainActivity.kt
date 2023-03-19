package com.example.lab2_unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = findViewById<Button>(R.id.button)
        val userNum: EditText = findViewById<EditText>(R.id.editText)
        val rG: RadioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val result: TextView = findViewById<TextView>(R.id.textView)
        val reverse:Switch = findViewById<Switch>(R.id.switch1)


        btn.setOnClickListener(View.OnClickListener {
            var converted = 0f
            val rbId: Int = rG.checkedRadioButtonId
            try {
                if (rbId != -1) {
                    val rB: RadioButton = findViewById<RadioButton>(rbId)
                    val rbVal: String = rB.text.toString()
                    if (rbVal == "Grams to cups" && !reverse.isChecked()) {
                        converted = userNum.text.toString().toFloat() / 240
                    } else if (rbVal == "Grams to cups" && reverse.isChecked()) {
                        converted = userNum.text.toString().toFloat() * 240
                    } else if (rbVal == "Mililiters to fluid ounces" && !reverse.isChecked()) {
                        converted = userNum.text.toString().toFloat() * 0.033814f
                    } else if (rbVal == "Mililiters to fluid ounces" && reverse.isChecked()) {
                        converted = userNum.text.toString().toFloat() / 0.033814f
                    }
                }
                result.text = "Result: $converted"
            } catch (e: NumberFormatException) {
                Log.d("error", "Error while converting number")
            }
        })
    }
}