package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    var pInt = 1
    var paoInt = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pim)

       //val int : Intent = Intent.getIntentOld()

        var pressaoSistolica = pressao.text.toString()//obtem o valor da pressao sistólica
        if(!pressaoSistolica.equals("")){
            pInt = pressaoSistolica.toInt()
            cont++
            Toast.makeText(applicationContext,"Nao esta vazio",
                Toast.LENGTH_SHORT).show()
        }
        var pao = PaO2.text.toString() //obtem o valor do PaO2
        if(pao.length != 0){
            paoInt = pao.toInt()
            cont++
            Toast.makeText(applicationContext,"Nao esta vazio",
                Toast.LENGTH_SHORT).show()

        }

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

    fun Resultado() : Int { //metodo do calculo
        val resul : Int = (paoInt * pInt) / 8

        return resul
    }

    fun clickCalcular(view : View){
        if(cont < 6){
            Toast.makeText(applicationContext,"Você não respondeu todas as perguntas!",
                Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(applicationContext,"Indo para a próxima página...",
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
