package com.example.xml_layout_lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.button)
        val text: EditText = findViewById<EditText>(R.id.editText)
        val rG: RadioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val tvTipAmt: TextView = findViewById<TextView>(R.id.tvTipAmount)
        val swRound: Switch = findViewById<Switch>(R.id.switch1)

        button.setOnClickListener(View.OnClickListener {
            var tipAmt = 0f
            val tipPercent: Float
            val rbId: Int = rG.checkedRadioButtonId
            try {
                tipAmt = text.text.toString().toFloat()
                if (rbId != -1) {
                    val rB: RadioButton = findViewById<RadioButton>(rbId)
                    val rbVal: String = rB.text.toString()
                    tipPercent = when (rbVal) {
                        "Amazing(20%)" -> 0.20f
                        "Good(18%)" -> 0.18f
                        "Okay(15%)" -> 0.15f
                        else -> 0f
                    }
                    tipAmt *= tipPercent
                    if (swRound.isChecked) {
                        tipAmt = tipAmt.roundToInt().toFloat()
                    }
                    tvTipAmt.text= "Tip Amount: $tipAmt"
                }
            } catch (e: NumberFormatException) {
                Log.d("error", "error in parsing")
            }
        })
    }
}