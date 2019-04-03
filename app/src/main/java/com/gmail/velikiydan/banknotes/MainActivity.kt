package com.gmail.velikiydan.banknotes

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception


class MainActivity : AppCompatActivity() {


    fun setKeyListener(result: TextView, list: List<TextView>, et: EditText, tv: TextView, multiply: Int) {
        et.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                val num = try {
                    et.text.toString().toInt() * multiply
                } catch (e: NumberFormatException) {
                    0
                }
                try {
                    tv.text = num.toString()
                    result.setTextColor(Color.GREEN)
                    result.textSize = 26F
                    result.text = list.sumBy { it.text.toString().toInt() }.toString()
                } catch (e: Exception) {
                    println("Error: $e")
                    return true
                }
                return false
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editCU500 = findViewById<EditText>(R.id.editCU500)
        val valueCU500 = findViewById<TextView>(R.id.valueCU500)

        val editCU200 = findViewById<EditText>(R.id.editCU200)
        val valueCU200 = findViewById<TextView>(R.id.valueCU200)

        val editCU100 = findViewById<EditText>(R.id.editCU100)
        val valueCU100 = findViewById<TextView>(R.id.valueCU100)

        val editCU50 = findViewById<EditText>(R.id.editCU50)
        val valueCU50 = findViewById<TextView>(R.id.valueCU50)

        val editCU20 = findViewById<EditText>(R.id.editCU20)
        val valueCU20 = findViewById<TextView>(R.id.valueCU20)

        val editCU10 = findViewById<EditText>(R.id.editCU10)
        val valueCU10 = findViewById<TextView>(R.id.valueCU10)

        val editCU5 = findViewById<EditText>(R.id.editCU5)
        val valueCU5 = findViewById<TextView>(R.id.valueCU5)

        val editCU2 = findViewById<EditText>(R.id.editCU2)
        val valueCU2 = findViewById<TextView>(R.id.valueCU2)

        val editCU1 = findViewById<EditText>(R.id.editCU1)
        val valueCU1 = findViewById<TextView>(R.id.valueCU1)

        val result = findViewById<TextView>(R.id.result)


        val list = listOf(
            valueCU500,
            valueCU200,
            valueCU100,
            valueCU50,
            valueCU20,
            valueCU10,
            valueCU5,
            valueCU2,
            valueCU1
        )

        fun setListener(et: EditText, tv: TextView, multiply: Int) = setKeyListener(result, list, et, tv, multiply)

        setListener(editCU500, valueCU500, 500)
        setListener(editCU200, valueCU200, 200)
        setListener(editCU100, valueCU100, 100)
        setListener(editCU50, valueCU50, 50)
        setListener(editCU20, valueCU20, 20)
        setListener(editCU10, valueCU10, 10)
        setListener(editCU5, valueCU5, 5)
        setListener(editCU2, valueCU2, 2)
        setListener(editCU1, valueCU1, 1)
    }


}

