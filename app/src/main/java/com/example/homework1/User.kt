package com.example.homework1

import java.lang.annotation.AnnotationFormatError
import java.util.*

class User() {

    private var Name: String = ""
        set(value) {
            if (value.length > 0)
                field = value
            else throw Exception("The name cannot be empty!")
        }

    private var Age: Int = 0
        set(value) {
            if (value > 0 && value < 150)
                field = value
            else throw Exception("Specify the real age (greater than 0 and less than 150)!")
        }

    private var Height: Int = 0
        set(value) {
            if (value > 0 && value < 250)
                field = value
            else throw Exception("Specify the real height (greater than 0 and less than 250)!")
        }

    private var Weight: Double = 0.0
        set(value) {
            if (value > 0 && value < 250)
                field = value
            else throw Exception("Specify the real weight (greater than 0 and less than 250)!")
        }

    constructor(name: String, age: Int, height: Int, weight: Double) : this() {
        Name = name
        Age = age
        Height = height
        Weight = weight
    }

    fun CalculateTaxes(): CalculatedResult {

        var bmi = CalculateBMI()
        var level =
            if (bmi < 18.5) WeightLevel.LACK else if (bmi < 24.9) WeightLevel.NORMAL
            else if (bmi < 29.9) WeightLevel.EXCESS else WeightLevel.OVERWEIGHT

        var ageRatio =
            if (Age < 18) 0.0 else if (Age <= 40) Age / 40.0 else if (Age <= 80) (80 - Age) / 40.0 else 0.0
        var weightTax = level.value * 10000 * ageRatio
        var nameTax = Name.length * 100 * ageRatio
        return CalculatedResult(weightTax, nameTax, level)
    }

    private fun CalculateBMI() : Double{
      val height = Height / 100.0
      return Weight / (height * height)
    }
}