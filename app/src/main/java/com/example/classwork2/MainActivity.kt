package com.example.classwork2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        var n = 0
        var results :List<Int>
        val radGroup0: RadioGroup = findViewById(R.id.radioGroup0)
        val rad0 = findViewById<RadioButton>(R.id.rad0)
        val rad1 = findViewById<RadioButton>(R.id.rad1)
        val rad2 = findViewById<RadioButton>(R.id.rad2)

        val input = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)
        val btn = findViewById<Button>(R.id.button)
        val status = findViewById<TextView>(R.id.status)
        btn.setOnClickListener {
            val t = input.text.toString()
            n = t.toIntOrNull()!!
            if (n != null) {
                if (rad0.isChecked) {
                    results = (1..n).filter{it%2 == 0}
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
                    listView.adapter = adapter
                } else if( rad1.isChecked){
                    results = (1..n).filter{it%2 != 0}
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
                    listView.adapter = adapter
                }else if( rad2.isChecked){
                    fun isSquare(number: Int): Boolean {
                        val root = kotlin.math.sqrt(number.toDouble()).toInt()
                        return root * root == number
                    }

                    results = (1..n).filter{ isSquare(it)}
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
                    listView.adapter = adapter
                }
            } else status.setText("Fail to convert your number to integer!")

        }
    }
}

