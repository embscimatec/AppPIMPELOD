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
import kotlin.math.abs
import kotlin.math.exp

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
    var admissao : Int = 0
    var baseDeExcesso : Double = 0.0
    var paoInt : Double = 0.0
    var pressaoSistolica : Double = 0.0
    var fio2 : Double = 0.0



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

                //podeCalcular = true;
            })

        ventilacaoMecanica.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.ventilacaosim == checkedId) {
                    ventilacao = 1;
                }
                cont++;
                //podeCalcular = true;
            })


        razaoEntrada.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.razaoEntradasim == checkedId) {
                    razao = 1;
                }
                cont++
            })

        circulacaoExtracorporea.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.circulacaosim == checkedId) {
                    circulacao = 1;
                }
                cont++

            })

        admissaoEletiva.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.admissaoSim == checkedId) {
                    admissao = 1;
                }
                cont++
            }
        )
    }

    fun radio1(view : View){
        val radio: RadioButton = findViewById(reacaoPupila.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Reação das pupilas: ${pupila}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio2(view : View){
        val radio: RadioButton = findViewById(diagnostico.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Alto risco: ${altoRisco}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio3(view : View){
        val radio: RadioButton = findViewById(ventilacaoMecanica.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Ventilação mecânica: ${ventilacao}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio4(view : View){
        val radio: RadioButton = findViewById(razaoEntrada.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Razão de entrada por cirurgia: ${razao}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio5(view : View){
        val radio: RadioButton = findViewById(circulacaoExtracorporea.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Fez circulação: ${circulacao}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio6(view : View){
        val radio: RadioButton = findViewById(admissaoEletiva.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Admissão: ${admissao}",
            Toast.LENGTH_SHORT).show()
    }

    fun getPressao(){
        val editTxt = findViewById<EditText>(R.id.pressao)
        val pressaotxt = editTxt.text.toString()
        pressaoSistolica = pressaotxt.toDouble()

    }

    fun getPaO2(){
        val editTxt = findViewById<EditText>(R.id.PaO2)
        val PaO2Txt = editTxt.text.toString()
        paoInt = PaO2Txt.toDouble()

    }

    fun getFiO2(){
        val editTxt = findViewById<EditText>(R.id.FiO2)
        val FiO2Txt = editTxt.text.toString()
        val FIO2 : Double = FiO2Txt.toDouble()
        fio2 = FIO2 / 100

    }

    fun getBase(){
        val editTxt = findViewById<EditText>(R.id.baseExcesso)
        val baseTxt = editTxt.text.toString()
        baseDeExcesso = baseTxt.toDouble()

    }

    fun Resultado() : Double { //metodo de obtenção do resultado
        val PIM2 : Double = ( (0.01395 * abs(pressaoSistolica - 120)) + (3.0791 * pupila) + (0.2888 * (100 * fio2/paoInt)) +
                (0.104 * abs(baseDeExcesso)) + (1.3352 * ventilacao) + (-1.0244 * razao) - (-0.7507 * circulacao) + (-0.9282 * admissao)
                + (1.6829 * altoRisco) + (-1.5770 * baixoRisco) + (-4.8841) )
        val r = PIM2.toString()
        //Log.println(r)

        /*Toast.makeText(applicationContext,"PIM2: ${PIM2}",
            Toast.LENGTH_SHORT).show()*/
        /*Toast.makeText(applicationContext,"${PIM2} e ${Math.abs(baseDeExcesso)}",
            Toast.LENGTH_SHORT).show() */

        val denominador = (1 + exp(PIM2));
        var prob = exp(PIM2);
        //Toast.makeText(applicationContext,"Resultado: ${prob}%",
          //  Toast.LENGTH_SHORT).show()
        prob = prob/denominador

        val resul = prob * 100
        return resul
    }

    fun clickCalcular(view : View){
        // Tentar usar receberPressao() aqui

        // métodos que recebem valores dos EditTexts
        getPressao()
        getPaO2()
        getBase()
        getFiO2()


        if(cont < 5){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas necessárias!",
                Toast.LENGTH_SHORT).show()
        }
        else{

            val resultado = Resultado()
            val resultadoStr = resultado.toString()

            txtResultado.text = "A probabilidade de morte é ${resultadoStr}"

            //Toast.makeText(applicationContext, "${resultadoStr} e ${resultado}",
               // Toast.LENGTH_SHORT).show()


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
