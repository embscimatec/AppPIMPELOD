package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Calcular : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular)
    }

    fun clickPIM (view : View){ //esse método nao está funcionando
        val intent = Intent (this, ficha_paciente::class.java )
        val escolha = "PIM"
        intent.putExtra("escolha", escolha)
        //startActivity(intent)
    }

    fun clickPELOD (view : View){ //esse método nao está funcionando
        val intent = Intent (this, ficha_paciente::class.java )
        val escolha = "PIM"
        intent.putExtra("escolha", escolha)
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        this.finish()
    }
}
