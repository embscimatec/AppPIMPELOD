package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pim.*

const val EXTRA_MESSAGE = "com.ieeecimatec.pim2pelod2.MESSAGE"

class PIM : AppCompatActivity() {

    var cont : Int = 0 //esse contador vai fazer a verificação dos radioGrups marcados
    var podeCalcular : Boolean = false //essa variavel vai controlar a passagem da pagina

    //declaração das variáveis para efetuação do calculo
    var pupila : Int = 0
    var pao22 : Int = 0
    var ventilacao : Int = 0
    var razao : Int = 0
    var circulacao : Int = 0
    var altoRisco : Int = 0
    var baixoRisco : Int = 0
    var baseDeExcesso = 1
    var paoInt = 1
    var pressaoSistolica = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pim)

        /*supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) */

        //radioButton da reação da pupila
        reacaoPupila.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.Reacaosim == checkedId) {
                    pupila = 1;
                }
                cont++
               // podeCalcular = true;
            })

        /*if(!reacaoPupila.isSelected()){
            podeCalcular = false;
        }*/


        diagnostico.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.diagnosticoSim == checkedId) {
                    altoRisco = 1
                }
                else{

                    baixoRisco = 1
                }
                cont++;
                //podeCalcular = true;
            })

        /*if(!Pao2.isSelected()){
            podeCalcular = false;
        }*/


        ventilacaoMecanica.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.ventilacaosim == checkedId) {
                    ventilacao = 1;
                }
                cont++;
                //podeCalcular = true;
            })
        /*if(!ventilacaoMecanica.isSelected()){
            podeCalcular = false;
        }*/

        razaoEntrada.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.razaoEntradasim == checkedId) {
                    razao = 1;
                }
                cont++
                //podeCalcular = true;
            })
        /*if(!razaoEntrada.isSelected()){
            podeCalcular = false;
        }*/

        circulacaoExtracorporea.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.circulacaosim == checkedId) {
                    circulacao = 1;
                }
                cont++
                //podeCalcular = true;
            })
        /*if(!circulacaoExtracorporea.isSelected()){
            podeCalcular = false;
        }*/
    }

    /*fun recebePressao(view : View){
        val pressao = findViewById<EditText>(R.id.pressao)
        pressaoSistolica = pressao.text.toString()
        if (pressaoSistolica != "") {
            Toast.makeText(applicationContext,"FOI!! ${pressaoSistolica}mmHg",
                Toast.LENGTH_SHORT).show()
        }

    }*/

    fun radio1(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Reação das pupilas: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio2(view : View){
        val radio: RadioButton = findViewById(diagnostico.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Alto risco: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio3(view : View){
        val radio: RadioButton = findViewById(ventilacaoMecanica.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Ventilação mecânica: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio4(view : View){
        val radio: RadioButton = findViewById(razaoEntrada.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Razão de entrada por cirurgia: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio5(view : View){
        val radio: RadioButton = findViewById(circulacaoExtracorporea.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Fez circulação: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun getPressao(){
        val editTxt = findViewById<EditText>(R.id.pressao)
        val pressaotxt = editTxt.text.toString()
        pressaoSistolica = pressaotxt.toInt()

    }

    fun getPaO2(){
        val editTxt = findViewById<EditText>(R.id.PaO2)
        val PaO2Txt = editTxt.text.toString()
        paoInt = PaO2Txt.toInt()

    }

    fun getBase(){
        val editTxt = findViewById<EditText>(R.id.baseExcesso)
        val baseTxt = editTxt.text.toString()
        baseDeExcesso = baseTxt.toInt()

    }

    fun Resultado() : Double { //metodo de obtenção do resultado
        val PIM2 : Double = ( (0.01395 * Math.abs(pressaoSistolica - 120)) + (3.0791 * pupila) + (0.2888 * (100 * paoInt)) +
                (0.104 * Math.abs(baseDeExcesso)) + (1.3552 * ventilacao) + (-1.0244 * razao) - (-0.07507 * circulacao) +
                (1.6829 * altoRisco) + (-1.5770 * baixoRisco) + (-4.8841) )
        val r = PIM2.toString()
        //Log.println(r)

        /*Toast.makeText(applicationContext,"${PIM2} e ${Math.abs(baseDeExcesso)}",
            Toast.LENGTH_SHORT).show() */

        val prob = (Math.exp(PIM2) / (1 + Math.exp(PIM2)) )

        val resul = prob * 100

        return resul
    }

    fun clickCalcular(view : View){
        // Tentar usar receberPressao() aqui

        // métodos que recebem valores dos EditTexts
        getPressao()
        getPaO2()
        getBase()



        if(cont < 5){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas! Pressao = ${pressaoSistolica}  PaO2 = ${paoInt} Base = ${baseDeExcesso}",
                Toast.LENGTH_SHORT).show()
        }
        else{

            val resultado : Double = Resultado()
            val resultadoStr = resultado.toString()

            Toast.makeText(applicationContext,"Indo para a próxima página... Pressao = ${pressaoSistolica} PaO2 = ${paoInt} Base ${baseDeExcesso}" +
                    "${resultadoStr} e ${resultado}",
                Toast.LENGTH_SHORT).show()



            val rep = "oi"

            val intent = Intent(this, splash_calculando::class.java)
            intent.putExtra("resultado", resultado)

            //passando o valor do resultado para a outra página
            startActivity(intent)

        }
    }

    fun onBackPressed(view : View){ //botao de retornar
        this.finish()
    }


}
