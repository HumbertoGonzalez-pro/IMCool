package com.example.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val intencion= intent

        val imc= intencion.getFloatExtra("BMI", 0.0F )
        val sexo = intencion.getStringExtra("gender")
        val age = intencion.getIntExtra("age",25)
        tvResultado.text= "$imc"


        btnRecalcular.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
    fun interpretaIMC(imc: Float, edad:Int, sexo: String){

        if(sexo=="f"){
            when(edad){
              in 19..24->{
                  when(imc){

                      in 18.9..22.1->{
                          tvEstado.text = "NORMAL"
                          tvMuestraRango.text = "Normal BMI range:"
                          tvRango.text = "18,9 - 22,1%"
                          tvMensaje.text= "You have a normal body, weight. Good job!"
                      }
                      in 22.2..25.5->{
                          
                      }
                  }
              }
            }
        } else if(sexo=="m"){

        }
    }
}