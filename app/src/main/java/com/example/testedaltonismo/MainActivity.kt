package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUESTCODE1 = 99
    val REQUESTCODE2 = 100
    val REQUESTCODE3 = 101

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

        var codImagem = 0
        var codRequest = 0

       when(v.id){
           R.id.teste1button->{
               codImagem = 1
               codRequest = REQUESTCODE1
           }
           R.id.teste2button->{
               codImagem = 2
               codRequest = REQUESTCODE2
           }
           R.id.teste3button->{
               codImagem = 3
               codRequest = REQUESTCODE3
           }
       }

        var i = Intent(this, TesteActivity::class.java)

        var param = Bundle()
        param.putInt("codImagem", codImagem)

        i.putExtras(param)

        startActivityForResult(i, codRequest)

    }

    fun verificar(v:View){

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

                        resultT1 = data?.getStringExtra("resposta")?.toInt()!!
                        Log.i("RESULTADO", "Resultado $resultT1")

                        resposta1TextView.text = "$resultT1"

                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
            REQUESTCODE2->{
                when(resultCode){
                    Activity.RESULT_OK->{

                        resultT2 = data?.getStringExtra("resposta")?.toInt()!!
                        Log.i("RESULTADO", "Resultado $resultT2")

                        resposta2TextView.text = "$resultT2"

                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
            REQUESTCODE3->{
                when(resultCode){
                    Activity.RESULT_OK->{

                        resultT3 = data?.getStringExtra("resposta")?.toInt()!!
                        Log.i("RESULTADO", "Resultado $resultT3")

                        resposta3TextView.text = "$resultT3"
                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
        }


    }
}
