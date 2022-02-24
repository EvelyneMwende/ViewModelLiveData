package com.example.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: TestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        //Observer to see when value has changed
        viewModel.currentNumber.observe(this, Observer {
            val tv_textView =findViewById<TextView>(R.id.tv_textView)
            //Takes the latest number that has been updated and put it into a string
            tv_textView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            val tv_booleanText=findViewById<TextView>(R.id.tv_booleanText)
            //Takes the latest Boolean that has been updated and put it into a string
            tv_booleanText.text = it.toString()
        })

        incrementText()


        }
    private fun incrementText(){
        val btn_button = findViewById<Button>(R.id.btn_button)
        btn_button.setOnClickListener{
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number %2 ==0

        }
    }
}