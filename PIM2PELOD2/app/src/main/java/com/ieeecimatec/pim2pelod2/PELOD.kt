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
import javax.xml.transform.dom.DOMLocator
import kotlin.math.exp

class PELOD : AppCompatActivity() {

    var cont : Int = 0 //esse contador vai fazer a verificação dos radioGrups marcados
    var pupila : Int = 5
    var ventilacao : Int = 0
    var glasInt : Int = 1
    var pao : Double = 0.0
    var fio2 : Double = 0.0
    var lactaInt : Int = 1
    var lactaFloat : Double = 1.0
    var creaInt : Int = 1
    var paco2Int : Int = 1
    var globInt : Int = 1
    var plaqInt : Int = 1
    var pressao : Double = 0.0
    var pressaoInt : Int = 0
    var eficiencia : Double = 0.0
    var eficienciaInt : Int = 0
    var meses : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelod)

    val mes = intent.getSerializableExtra("mes") as Int
        meses = mes

        //radioButton da reação da pupila
        reacaoPupila.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.Reacaosim == checkedId) {
                    pupila = 0;
                }
                cont++
            })
        //radioButton ventilacao mecanica
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
        val glas : Double = glasglow.toDouble()

        if(glas >= 11){
            glasInt = 0
        } else if (glas in 5.0..10.0) {
            glasInt = 1
        } else {
            glasInt = 4
        }
    }

    fun getPaO2(){
        val editTxt = findViewById<EditText>(R.id.PaO2)
        val PaO2Txt = editTxt.text.toString()
        pao = PaO2Txt.toDouble()
    }

    fun getFiO2(){
        val editTxt = findViewById<EditText>(R.id.FiO2)
        val FiO2Txt = editTxt.text.toString()
        val FIO2 : Double = FiO2Txt.toDouble()
        fio2 = FIO2 / 100

    }

    fun getEficiencia(){
        eficiencia = (pao/fio2)*100
        if (eficiencia >= 61) {
            eficienciaInt = 0
        }
        else{
            eficienciaInt = 2
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
        val creatina : Double = baseTxt.toDouble()

        if (meses < 1){
            if (creatina <= 69){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 1..11) {

            if (creatina <= 22){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 12..23) {

            if (creatina <= 34){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 24..59) {

            if (creatina <= 50){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else if (meses in 60..143) {

            if (creatina <= 58){
                creaInt = 0
            } else {
                creaInt = 2
            }

        } else {

            if (creatina <= 92){
                creaInt = 0
            } else {
                creaInt = 2
            }
        }

    }

    fun getPressao(){
        val editTxt = findViewById<EditText>(R.id.pressaoArt)
        val baseTxt = editTxt.text.toString()
        pressao = baseTxt.toDouble()

        if (meses < 1){
            if (pressao >= 46){
                pressaoInt = 0
            } else if (pressao in 31.0..45.0) {
                pressaoInt = 2
            } else if (pressao in 17.0..30.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        } else if (meses in 1..11) {

            if (pressao >= 55){
                pressaoInt = 0
            } else if (pressao in 39.0..54.0) {
                pressaoInt = 2
            } else if (pressao in 25.0..38.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        } else if (meses in 12..23) {
            if (pressao >= 60){
                pressaoInt = 0
            } else if (pressao in 44.0..59.0){
                pressaoInt = 2
            } else if (pressao in 31.0..43.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        } else if (meses in 24..59) {
            if (pressao >= 62){
                pressaoInt = 0
            } else if (pressao in 46.0..61.0) {
                pressaoInt = 2
            } else if (pressao in 32.0..44.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        } else if (meses in 60..143) {

            if (pressao >= 65){
                pressaoInt = 0
            } else if (pressao in 49.0..64.0) {
                pressaoInt = 2
            } else if (pressao in 36.0..48.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        } else {
            if (pressao >= 67){
                pressaoInt = 0
            } else if (pressao in 52.0..66.0) {
                pressaoInt = 2
            } else if (pressao in 38.0..51.0) {
                pressaoInt = 3
            } else {
                pressaoInt = 6
            }
        }

    }


    fun getPaCO2(){
        val editTxt = findViewById<EditText>(R.id.PaCO2)
        val PaCO2Txt = editTxt.text.toString()
        val paco2 : Double = PaCO2Txt.toDouble()

        if (paco2 >= 95){
            paco2Int = 3
        } else if (paco2 in 59.0..94.0){
            paco2Int = 1
        } else {
            paco2Int = 0
        }

    }

    fun getGlob(){
        val editTxt = findViewById<EditText>(R.id.globulosBrancos)
        val GlobTxt = editTxt.text.toString()
        val glob : Double = GlobTxt.toDouble()

        if (glob > 2) {
            globInt = 0
        } else {
            globInt = 2
        }
    }

    fun getPlaq(){
        val editTxt = findViewById<EditText>(R.id.Plaquetas)
        val PlaqTxt = editTxt.text.toString()
        val plaq = PlaqTxt.toDouble()

        if (plaq >= 142) {
            plaqInt = 0
        } else if (plaq in 77.0..141.0) {
            plaqInt = 1
        } else {
            plaqInt = 2
        }

    }

    fun Resultado() : Double { //metodo de obtenção do resultado
        val PELOD2  = (glasInt + pupila + lactaInt + pressaoInt + creaInt + eficienciaInt + globInt + plaqInt)
        //val r = PELOD2.toString()
        var logit = -6.61 + (0.47 * PELOD2)
        logit *= -1

        val denominador = 1 + exp(logit)
        val prob : Double = 1/denominador

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
        getFiO2()
        getEficiencia() //metodo que calcula FiO2/PaO2 (%)
        getPaCO2()
        getGlob()
        getPlaq()



        if(cont < 2){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas!",
                Toast.LENGTH_SHORT).show()
        }
        else{

            val resultado : Double = Resultado()
            val resultadoStr = resultado.toString()

            Toast.makeText(applicationContext,"Indo para a próxima página..." +
                    "${resultadoStr} e ${resultado}",
                Toast.LENGTH_SHORT).show()



            //val rep = "oi"

            val intent = Intent(this, splash_calculando::class.java)
            intent.putExtra("resultado", resultado)

            //passando o valor do resultado para a outra página
            startActivity(intent)

        }
    }


}