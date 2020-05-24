package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pim.*

class PIM : AppCompatActivity() {

    var cont : Int = 0 //esse contador vai fazer a verificação dos radioGrups marcados
    var podeCalcular : Boolean = false //essa variavel vai controlar a passagem da pagina

    //declaração das variáveis para efetuação do calculo
    var pupila : Int = 0
    var pao22 : Int = 0
    var baseDeExcesso : Int = 0
    var ventilacao : Int = 0
    var razao : Int = 0
    var circulacao : Int = 0
    var altoRisco : Int = 0
    var baixoRisco : Int = 0
    var paoInt = 1
    var pressaoSistolica = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pim)

       //val int : Intent = Intent.getIntentOld()

        /*var PressaoSistolica = findViewById<EditText>(R.id.pressao).text.toString() //obtem o valor da pressao sistólica
        if(!PressaoSistolica.equals("")){
            pressaoSistolica = PressaoSistolica.toInt()
            cont++
            Toast.makeText(applicationContext,"${PressaoSistolica}",
                Toast.LENGTH_SHORT).show()
        }
        var pao = findViewById<EditText>(R.id.PaO2).text.toString() //obtem o valor do PaO2
        if(!pao.equals("")){
            paoInt = pao.toInt()
            cont++
            Toast.makeText(applicationContext,"${pao}",
                Toast.LENGTH_SHORT).show()

        } */

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


        Pao2.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.Pao2sim == checkedId) {
                    pao22 = 1;
                }
                cont++;
                //podeCalcular = true;
            })

        /*if(!Pao2.isSelected()){
            podeCalcular = false;
        }*/

        baseExcesso.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                if (R.id.baseExcessosim == checkedId) {
                    baseDeExcesso = 1;
                }
                cont++;
                //podeCalcular = true;
            })
        /*if(!baseExcesso.isSelected()){
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
        val radio: RadioButton = findViewById(Pao2.checkedRadioButtonId)
        Toast.makeText(applicationContext,"PAO2: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio3(view : View){
        val radio: RadioButton = findViewById(baseExcesso.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Base de excesso: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio4(view : View){
        val radio: RadioButton = findViewById(ventilacaoMecanica.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Ventilação mecânica: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio5(view : View){
        val radio: RadioButton = findViewById(razaoEntrada.checkedRadioButtonId)
        Toast.makeText(applicationContext,"Razão de entrada por cirurgia: ${radio.text}",
            Toast.LENGTH_SHORT).show()
    }

    fun radio6(view : View){
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

    fun Resultado() : Double { //metodo do calculo
        val PIM2 : Double = ((0.01395 * Math.abs(pressaoSistolica - 120)) + (3.0791 * pupila) + (0.2888 * (100 * paoInt)) + (-1.0244 * razao)
                - (-0.07507 * circulacao) + (1.6829 * altoRisco) + (-1.5770 * baixoRisco) + (-4.8841) )

        val prob = (Math.exp(PIM2) / (1 + Math.exp(PIM2)) )

        val resul = prob * 100

        return resul
    }

    fun clickCalcular(view : View){
        // Tentar usar receberPressao() aqui

        getPressao()
        getPaO2()
        if(cont < 6){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas! Pressao = ${pressaoSistolica} e PaO2 = ${paoInt}",
                Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(applicationContext,"Indo para a próxima página... Pressao = ${pressaoSistolica} e PaO2 = ${paoInt}",
                Toast.LENGTH_SHORT).show()

            val resposta = Resultado()
            val rep = "oi"

            /*val intent = Intent(this, Resultado::class.java)
            intent.putExtra(Intent.EXTRA_COMPONENT_NAME,)
            intent.putExtra("resposta", resposta) //passando o valor do resultado para a outra página
            startActivity(intent)
            //na outra página
            val resposta = getIntent().getExtras().

             */
        }
    }


}
