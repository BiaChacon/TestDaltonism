package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_teste.*

class TesteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        var param = intent.extras
        var codImagem = param?.getInt("codImagem")

        when(codImagem){
            1->imageView.setImageResource(R.drawable.im2)
            2->imageView.setImageResource(R.drawable.im15)
            3->imageView.setImageResource(R.drawable.im74)
        }

        cancelaButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        enviarButton.setOnClickListener {
            var i = Intent()
            i.putExtra("resposta", respostaEditText.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
        

    }
}
