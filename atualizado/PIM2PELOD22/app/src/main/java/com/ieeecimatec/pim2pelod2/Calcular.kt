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
        //val intent = Intent (this, Ficha_paciente_pim::class.java )
        //startActivity(intent)
    }

    fun clickPELOD (view : View){ //esse método nao está funcionando
        //val intent = Intent (this, Ficha_paciente_PELOD::class.java )
        //startActivity(intent)
    }


    fun onBackPressed(view: View){
        this.finish()
    }
}
