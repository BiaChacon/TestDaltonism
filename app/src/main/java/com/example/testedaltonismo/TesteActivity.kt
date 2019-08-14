package com.example.testedaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_teste.*

class TesteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)

        var param = intent.extras
        var id = param?.getInt("ID")

        if(id == 1)
            imageView.setImageResource(R.drawable.im2)
        if(id == 2)
            imageView.setImageResource(R.drawable.im15)
        if(id == 2)
            imageView.setImageResource(R.drawable.im74)

    }
}
