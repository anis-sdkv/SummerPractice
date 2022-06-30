package com.example.homework1

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var nameInput: EditText? = null
    private var ageInput: EditText? = null
    private var heightInput: EditText? = null
    private var weightInput: EditText? = null
    private var result: TextView? = null
    private var calculateButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInput = findViewById(R.id.nameInputField)
        ageInput = findViewById(R.id.ageInputField)
        heightInput = findViewById(R.id.heightInputField)
        weightInput = findViewById(R.id.weightInputField)
        result = findViewById(R.id.resultText)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton?.setOnClickListener() {
            onButtonClick()
        }
    }

    fun onButtonClick() {
        try {
            var user = User(
                nameInput?.text.toString(),
                if (ageInput?.text.toString() == "") 0 else ageInput?.text.toString().toInt(),
                if (heightInput?.text.toString() == "") 0 else heightInput?.text.toString().toInt(),
                if (weightInput?.text.toString() == "") 0.0 else weightInput?.text.toString().toDouble()
            )
            var _result = user.CalculateTaxes()
            if (_result.NameTax == 0.0)
                result?.setText("Your age exempts you from taxes!")
            else if(_result.WeightTax < 0)
                result?.setText("You weigh very little, you need to eat more. " +
                        "You receive an additional ${Math.abs(_result.WeightTax)} coins from the party for food! " +
                        "You have to pay ${_result.NameTax.toInt()} coins for your name.")
            else if(_result.WeightTax == 0.0)
                result?.setText("You have a normal weight, you only have to pay ${_result.NameTax.toInt()} coins for the name.")
            else
                result?.setText("You are overweight! Take care of your health. The weight tax is ${_result.WeightTax} coins. " +
                        "The name tax is ${_result.NameTax.toInt()} coins.")
        }
        catch (e: Exception){
            result?.setText(e.message)
        }
        result?.visibility = View.VISIBLE
    }
}