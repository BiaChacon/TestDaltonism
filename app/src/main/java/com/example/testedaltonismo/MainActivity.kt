package com.example.testedaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var resultT1 = 0
    var resultT2 = 0
    var resultT3 = 0

    var resultFinal = "Faça o teste"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resposta1TextView.text = ("$resultT1")
        resposta2TextView.text = ("$resultT2")
        resposta3TextView.text = ("$resultT3")

        resultadoTextView.text = ("$resultFinal")

    }

    fun  clique(v:View){

    }

}
