package com.ieeecimatec.pim2pelod2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class ficha_paciente_pim : AppCompatActivity() {
    var nome_paciente = ""
    var idade : Int = 0
    var mesesPaciente : Int = 0
    val hoje = Calendar.getInstance() //recebe a data atual


    @RequiresApi(Build.VERSION_CODES.O)
    val miniDate : Calendar = Calendar.Builder().setDate(hoje.get(Calendar.YEAR) - 16, hoje.get(
        Calendar.MONTH), hoje.get(Calendar.DAY_OF_MONTH)).build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_paciente_pim)
        val date_Picker = findViewById<DatePicker>(R.id.datePicker)
        //date_Picker.setDatePickerFormat("DMY");
        date_Picker.maxDate = Calendar.getInstance().timeInMillis  //maior data possivel
        date_Picker.minDate = miniDate.timeInMillis //menor data possivel
        date_Picker.init(hoje.get(Calendar.YEAR), hoje.get(Calendar.MONTH),
            hoje.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            idade = getAge(month, year, day)
            mesesPaciente = getMeses(month, year, day)
        //    val msg = "Você Selecionou: $day/$month/$year. Você possui ${idade} anos e tem ${mesesPaciente} meses totais de vida."
        //    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }



        val mes = date_Picker.month
        val ano = date_Picker.year
        val dia = date_Picker.dayOfMonth
    }

    fun getAge(mes : Int, ano : Int, dia : Int) : Int{ //retorna o valor da idade do paciente
        var age : Int = getMeses(mes, ano, dia)
        age /= 12
        age = age.toInt()
        return age
    }

    fun getMeses(mes : Int, ano : Int, dia : Int) : Int {
        val anoAtual : Int = hoje.get(Calendar.YEAR)
        val mesAtual : Int = hoje.get(Calendar.MONTH)
        val diaAtual : Int = hoje.get(Calendar.DAY_OF_MONTH)

        val anoEmMes = (anoAtual - ano) * 12
        val meses = (mesAtual - mes)
        var diaEmMes = diaAtual - dia

        if ((diaEmMes < 0 && meses == 0) ||(diaEmMes < 0 && anoEmMes == 0)) {
            diaEmMes = -1
        } else {
            diaEmMes = 0
        }

        return anoEmMes + meses + diaEmMes

    }

    fun getNome(){ //recebe o nome do paciente
        val editTxt = findViewById<EditText>(R.id.nomePaciente)
        nome_paciente = editTxt.text.toString()
    }

    fun onBackPressed(view : View){ //botao de retornar
        this.finish()
    }

    fun onContinuarPressed(view : View){ //chama a próxima tela (1 para PIM, 0 para PELOD)
        if(mesesPaciente == 0){
            val msg = "Você não marcou a data de nascimento!"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        else {
            startActivity(Intent(this, PIM::class.java ))
        }

    }

}
