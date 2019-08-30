package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUESTCODE1 = 99
    val REQUESTCODE2 = 100
    val REQUESTCODE3 = 101

    var resultT1 = 0
    var resultT2 = 0
    var resultT3 = 0

    var resultFinal = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resposta1TextView.text = ("$resultT1")
        resposta2TextView.text = ("$resultT2")
        resposta3TextView.text = ("$resultT3")

    }

    fun  clique(v:View){

        var codImage = 0
        var codRequest = 0

       when(v.id){
           R.id.teste1button->{
               codImage = 1
               codRequest = REQUESTCODE1
           }
           R.id.teste2button->{
               codImage = 2
               codRequest = REQUESTCODE2
           }
           R.id.teste3button->{
               codImage = 3
               codRequest = REQUESTCODE3
           }
       }

        var i = Intent(this, TesteActivity::class.java)

        var param = Bundle()
        param.putInt("codImage", codImage)

        i.putExtras(param)

        startActivityForResult(i, codRequest)

    }

    fun verificar(){

        if(resultT1 == 0 || resultT2 == 0  || resultT3 == 0 ){
            Toast.makeText(this, "erro na verifição" ,Toast.LENGTH_SHORT).show()
        }else {
            if(resultT1 == 2 && resultT2 == 15 && resultT3 == 74) {
                resultFinal = "Normal"
                resultadoTextView.text = ("$resultFinal")
            }else {
                resultFinal = "Procurar um médico"
                resultadoTextView.text = ("$resultFinal")
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUESTCODE1->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT1 = data?.getStringExtra("resp")?.toInt()!!
                        resposta1TextView.text = "$resultT1"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Cancelou" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTCODE2->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT2 = data?.getStringExtra("resp")?.toInt()!!
                        resposta2TextView.text = "$resultT2"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Cancelou" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTCODE3->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT3 = data?.getStringExtra("resp")?.toInt()!!
                        resposta3TextView.text = "$resultT3"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this, "Cancelou" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("resp1", resultT1)
        outState.putInt("resp2", resultT2)
        outState.putInt("resp3", resultT3)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        resultT1 = savedInstanceState.getInt("resp1")
        resultT2 = savedInstanceState.getInt("resp2")
        resultT3 = savedInstanceState.getInt("resp3")

        resposta1TextView.text = "$resultT1"
        resposta2TextView.text = "$resultT2"
        resposta3TextView.text = "$resultT3"

    }

}
