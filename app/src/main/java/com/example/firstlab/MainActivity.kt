package com.example.firstlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Input first number
        val input1 = findViewById<EditText>(R.id.input1)
        input1.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
        //input second number
        val input2 = findViewById<EditText>(R.id.input2)
        input2.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL

        //buttons initialization by id
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val result = findViewById<TextView>(R.id.result)

        //event handler for the "*" button
        multiply.setOnClickListener {
            val res = input1.text.toString().toDouble() * input2.text.toString().toDouble()
            result.text = res.toString()
        }
        //event handler for the "/" button
        divide.setOnClickListener {
            if (input2.text.toString().toDouble() != 0.0) {
                val res = input1.text.toString().toDouble() / input2.text.toString().toDouble()
                result.text = res.toString()
            } else {
                result.text = "Деление на ноль!"
            }
        }
        //event handler for the "+" button
        plus.setOnClickListener { v: View? ->
            result.text = (input1.text.toString().toDouble() + input2.text.toString().toDouble()).toString()
        }
        //event handler for the "-" button
        minus.setOnClickListener { v: View? ->
            result.text = (input1.text.toString().toDouble() - input2.text.toString().toDouble()).toString()
        }
    }
}