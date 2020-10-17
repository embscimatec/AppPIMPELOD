package com.ieeecimatec.pim2pelod2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ieeecimatec.pimpelod.PIM
import com.ieeecimatec.pimpelod.R
import java.util.*
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.YEAR

class Ficha_paciente : AppCompatActivity() {

    var nome_paciente = ""
    var idade : Int = 0
    var meses : Int = 0
    val hoje = Calendar.getInstance() //recebe a data atual
    @RequiresApi(Build.VERSION_CODES.O)
    //recebe a data mínima (idade maxima)
    val miniDate : Calendar = Calendar.Builder().setDate(hoje.get(Calendar.YEAR) - 16, hoje.get(Calendar.MONTH), hoje.get(Calendar.DAY_OF_MONTH)).build()


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
            val month = month + 1
            idade = getAge(month, year, day)
            val msg = "Você Selecionou: $day/$month/$year. Você possui ${idade} anos e tem ${meses} meses de vida."
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }



        val mes = date_Picker.month
        val ano = date_Picker.year
        val dia = date_Picker.dayOfMonth
    }

    fun getAge(mes : Int, ano : Int, dia : Int) : Int{ //retorna o valor da idade do paciente
        var age : Int = 0
        if(mes <= hoje.get(Calendar.MONTH) && dia <= hoje.get(Calendar.DAY_OF_MONTH)){
            age = hoje.get(Calendar.YEAR)  - ano
            meses = (age * 12) + (hoje.get(Calendar.MONTH) - mes)
        }
        else{
            age = hoje.get(Calendar.YEAR)- ano
            age -= 1
            var extra = mes - hoje.get(Calendar.MONTH)
            extra -= 12
            meses = (age * 12) + extra

        }
        return age;
    }

    fun getNome(){ //recebe o nome do paciente
        val editTxt = findViewById<EditText>(R.id.nomePaciente)
        nome_paciente = editTxt.text.toString()
    }

    fun onBackPressed(view : View){ //botao de retornar
        this.finish()
    }

    fun onContinuarPressed(view : View){ //chama a próxima tela (1 para PIM, 0 para PELOD)

            val intent = Intent (this, PIM::class.java )
            startActivity(intent)

    }
}
