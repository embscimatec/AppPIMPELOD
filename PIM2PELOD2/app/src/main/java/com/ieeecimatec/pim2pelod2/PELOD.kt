package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pelod.*
import kotlin.math.exp

class PELOD : AppCompatActivity() {

    var cont : Int = 0 //esse contador vai fazer a verificação dos radioGrups marcados
    var pupila : Int = 5
    var ventilacao : Int = 0
    var glasInt = 1
    var paoInt = 1
    var lactaInt : Int = 1
    var lactaFloat : Double = 1.0
    var creaInt : Int = 1
    var paco2Int : Int = 1
    var globInt : Int = 1
    var plaqInt : Int = 1
    var pressao : Int = 0
    val meses : Int = intent.getSerializableExtra("meses") as Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelod)


        //radioButton da reação da pupila
        reacaoPupila.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.Reacaosim == checkedId) {
                    pupila = 0;
                }
                cont++
                // podeCalcular = true;
            })


        ventilacaoMecanica.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.ventilacaosim == checkedId) {
                    ventilacao = 3;
                }
                cont++;
                //podeCalcular = true;
            })

    }

    fun radio1(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Reação das pupilas: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio2(view : View){
        val radio: RadioButton = findViewById(ventilacaoMecanica.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Ventilação mecânica: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun getGlasglow(){
        val editTxt = findViewById<EditText>(R.id.Glasglow)
        val glasglow = editTxt.text.toString()
        glasInt = glasglow.toInt()

        if(glasInt >= 11){
            glasInt = 0
        } else if (glasInt in 5..10) {
            glasInt = 1
        } else {
            glasInt = 4
        }
    }

    fun getPaO2(){
        val editTxt = findViewById<EditText>(R.id.PaO2)
        val PaO2Txt = editTxt.text.toString()
        paoInt = PaO2Txt.toInt()
        if (paoInt >= 61) {
            paoInt = 0
        } else {
            paoInt = 2
        }
    }

    fun getLacta(){
        val editTxt = findViewById<EditText>(R.id.Lactatemia)
        val baseTxt = editTxt.text.toString()
        lactaFloat = baseTxt.toDouble()

        if (lactaFloat >= 11.0) {
            lactaInt = 4
        } else if (lactaFloat in 5.0..10.9) {
            lactaInt = 1
        } else {
            lactaInt = 0
        }

    }

    fun getCreatinina(){
        val editTxt = findViewById<EditText>(R.id.Creatina)
        val baseTxt = editTxt.text.toString()
        creaInt = baseTxt.toInt()

        if (meses < 1){
            if (creaInt <= 69){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 1..11) {

            if (creaInt <= 22){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 12..23) {

            if (creaInt <= 34){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 24..59) {

            if (creaInt <= 50){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 60..143) {

            if (creaInt <= 58){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else {

            if (creaInt <= 92){
                creaInt = 0
            } else {
                creaInt = 2
            }
        }

    }

    fun getPressao(){
        val editTxt = findViewById<EditText>(R.id.pressaoArt)
        val baseTxt = editTxt.text.toString()
        pressao = baseTxt.toInt()

        if (meses < 1){
            if (pressao >= 46){
                pressao = 0
            } else if (pressao in 31..45) {
                pressao = 2
            } else if (pressao in 17..30) {
                pressao = 3
            } else {
                pressao = 6
            }
        } else if (meses in 1..11) {

            if (pressao >= 55){
                pressao = 0
            } else if (pressao in 39..54) {
                pressao = 2
            } else if (pressao in 25..38) {
                pressao = 3
            } else {
                pressao = 6
            }
        } else if (meses in 12..23) {
            if (pressao >= 60){
                pressao = 0
            } else if (pressao in 44..59) {
                pressao = 2
            } else if (pressao in 31..43) {
                pressao = 3
            } else {
                pressao = 6
            }
        } else if (meses in 24..59) {
            if (pressao >= 62){
                pressao = 0
            } else if (pressao in 46..61) {
                pressao = 2
            } else if (pressao in 32..44) {
                pressao = 3
            } else {
                pressao = 6
            }
        } else if (meses in 60..143) {

            if (pressao >= 65){
                pressao = 0
            } else if (pressao in 49..64) {
                pressao = 2
            } else if (pressao in 36..48) {
                pressao = 3
            } else {
                pressao = 6
            }
        } else {
            if (pressao >= 67){
                pressao = 0
            } else if (pressao in 52..66) {
                pressao = 2
            } else if (pressao in 38..51) {
                pressao = 3
            } else {
                pressao = 6
            }
        }


    }

    fun getPaCO2(){
        val editTxt = findViewById<EditText>(R.id.PaCO2)
        val PaCO2Txt = editTxt.text.toString()
        paco2Int = PaCO2Txt.toInt()

        if (paco2Int >= 95){
            paco2Int = 3
        } else if (paco2Int in 59..94){
            paco2Int = 1
        } else {
            paco2Int = 0
        }

    }

    fun getGlob(){
        val editTxt = findViewById<EditText>(R.id.globulosBrancos)
        val GlobTxt = editTxt.text.toString()
        globInt = GlobTxt.toInt()

        if (globInt > 2) {
            globInt = 0
        } else {
            globInt = 2
        }
    }

    fun getPlaq(){
        val editTxt = findViewById<EditText>(R.id.Plaquetas)
        val PlaqTxt = editTxt.text.toString()
        plaqInt = PlaqTxt.toInt()

        if (plaqInt >= 142) {
            plaqInt = 0
        } else if (plaqInt in 77..141) {
            plaqInt = 1
        } else {
            plaqInt = 2
        }

    }

    fun Resultado() : Double { //metodo de obtenção do resultado
        val PELOD2 : Int = (glasInt + pupila + lactaInt + pressao + creaInt + paoInt + globInt + plaqInt)
        //val r = PELOD2.toString()
        var logit = -6.61 + (0.47 * PELOD2)
        logit *= -1

        val denominador = 1 + exp(logit)
        val prob = 1/denominador

        return prob * 100
    }

    fun clickCalcular(view : View){
        // Tentar usar receberPressao() aqui

        // métodos que recebem valores dos EditTexts
        getGlasglow()
        getLacta()
        getPressao()
        getCreatinina()
        getPaO2()
        getPaCO2()
        getGlob()
        getPlaq()

        if(cont < 5){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas!",
                Toast.LENGTH_SHORT).show()
        }
        else{

            val resultado : Double = Resultado()
            val resultadoStr = resultado.toString()

            Toast.makeText(applicationContext,"Indo para a próxima página..." +
                    "${resultadoStr} e ${resultado}",
                Toast.LENGTH_SHORT).show()



            val rep = "oi"

            val intent = Intent(this, splash_calculando::class.java)
            intent.putExtra("resultado", resultado)

            //passando o valor do resultado para a outra página
            startActivity(intent)

        }
    }


}