package com.ieeecimatec.pim2pelod2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pim.*

class PIM : AppCompatActivity() {


    var pupila : Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pim)

        val pressaoSistolica = pressao.text.toString() //obtem o valor da pressao sistólica
        val pao = PaO2.text.toString() //obtem o valor do PaO2

        //radioButton da reação da pupila
        val radioGroup1 = findViewById<RadioGroup>(R.id.reacaoPupila)
        radioGroup1?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.Reacaosim == checkedId) "SIM" else "NAO"

        }

        val radioGroup2 = findViewById<RadioGroup>(R.id.Pao2)
        radioGroup2?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.Pao2sim == checkedId) "SIM" else "NAO"

        }

        val radioGroup3 = findViewById<RadioGroup>(R.id.baseExcesso)
        radioGroup3?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.baseExcessosim == checkedId) "SIM" else "NAO"

        }

        val radioGroup4 = findViewById<RadioGroup>(R.id.ventilacaoMecanica)
        radioGroup4?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.ventilacaosim == checkedId) "SIM" else "NAO"

        }

        val radioGroup5 = findViewById<RadioGroup>(R.id.razaoEntrada)
        radioGroup5?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.razaoEntradasim == checkedId) "SIM" else "NAO"

        }

        val radioGroup6 = findViewById<RadioGroup>(R.id.circulacaoExtracorporea)
        radioGroup6?.setOnCheckedChangeListener { group, checkedId ->
            var text = "You selected: "
            text += if (R.id.circulacaosim == checkedId) "SIM" else "NAO"

        }


    }

    fun radio1(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Reação das pupilas: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio2(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"PAO2: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio3(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Base de excesso: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio4(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Ventilação mecânica: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio5(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Razão de entrada por cirurgia: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio6(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Fez circulação: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

}
