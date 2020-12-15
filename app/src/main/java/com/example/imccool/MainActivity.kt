package com.example.imccool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var contadorPeso:Int = 65
    var contadorEdad:Int =21
    var altura:Int =163
    var sexo:String= "hola"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekAltura.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if (progress <= 100){
                    seekAltura.setProgress(100)
                    tvAltura.text = "100"
                    altura=100
                }else{
                    tvAltura.text = "$progress"
                    altura= progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })


        btnEdadLess.setOnClickListener(this)
        btnEdadMore.setOnClickListener(this)
        btnPesoLess.setOnClickListener(this)
        btnPesoMore.setOnClickListener(this)
        maleBtn.setOnClickListener(this)
        femaleBtn.setOnClickListener(this)
        btnCalcular.setOnClickListener(this)

        tvPeso.text="$contadorPeso"
        tvEdad.text="$contadorEdad"
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            //edad
            R.id.btnEdadLess->{
                contadorEdad--
                tvEdad.text= "$contadorEdad"
            }
            R.id.btnEdadMore->{
                contadorEdad++
                tvEdad.text= "$contadorEdad"
            }
            //peso
            R.id.btnPesoLess->{
                contadorPeso--
                tvPeso.text= "$contadorPeso"
            }
            R.id.btnPesoMore->{
                contadorPeso++
                tvPeso.text= "$contadorPeso"
            }
            R.id.maleBtn->sexo="F"
            R.id.femaleBtn->sexo="M"
            R.id.btnCalcular->{
                val imc = calculaIMC(contadorPeso, altura)
                val intencion = Intent(this,SegundaActivity::class.java)
                intencion.putExtra("BMI",imc)
                intencion.putExtra("gender", sexo)
                intencion.putExtra("age",contadorEdad)
                startActivity(intencion)

            }

        }
    }
    fun calculaIMC(peso:Int, altura:Int): Float {
        val pesoF = peso.toFloat()
        val alturaF = altura.toFloat()/100
        var imc =pesoF/(alturaF*alturaF)

        return imc.toFloat()
    }
}