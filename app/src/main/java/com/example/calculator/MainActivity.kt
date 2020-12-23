package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var Variable1:Double = 0.0
    private var Variable2:Double = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        Button0.setOnClickListener(this)
        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)

        backspaceButton.setOnLongClickListener{
            resultTextView.text = ""
            return@setOnLongClickListener true
        }



        pointButton.setOnClickListener {
            if (resultTextView.text.isNotEmpty()) {
                resultTextView.text = resultTextView.text.toString() + "."
                pointButton.isClickable = false
            }
        }
    }

    fun equal(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty() && operation.isNotEmpty()) {
            Variable2 = value.toDouble()
            var result:Double = 0.0
            if (operation == "/") {
                if (Variable2 == 0.0) {
                    Toast.makeText(this, "Can't Divide by 0", Toast.LENGTH_SHORT).show()
                } else {
                    result = Variable1/Variable2;
                    resultTextView.text = result.toString()
                }
            }
            if (operation == "+"){
                result = Variable1 + Variable2
                resultTextView.text = result.toString()
            }
            if (operation == "-"){
                result = Variable1 - Variable2
                resultTextView.text = result.toString()
            }
            if (operation == "X"){
                result = Variable1 * Variable2
                resultTextView.text = result.toString()
            }


            operation = ""
            Variable1 = 0.0
            Variable2 = 0.0
        }
    }

    fun add(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            Variable1 = value.toDouble()
            operation = "+"
            resultTextView.text = ""
        }

    }

    fun subtraction(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            Variable1 = value.toDouble()
            operation = "-"
            resultTextView.text = ""
        }

    }

    fun multiply(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            Variable1 = value.toDouble()
            operation = "X"
            resultTextView.text = ""
        }

    }

    fun divide(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            Variable1 = value.toDouble()
            operation = "/"
            resultTextView.text = ""
        }
    }

    fun backspace(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty())
            resultTextView.text = value.substring(0, value.length - 1)
            if (resultTextView.text.contains(".") == true){
                pointButton.isClickable = false
            }
    }

    override fun onClick(v: View?) {
        val button = v as Button
        resultTextView.text = resultTextView.text.toString() + button.text.toString()
    }
}