package com.ieeecimatec.pimpelod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickPIM (view : View){ //esse método nao está funcionando
        val intent = Intent (this, Ficha_paciente_Pim::class.java )
        startActivity(intent)
    }

    fun clickPELOD (view : View){ //esse método nao está funcionando
        val intent = Intent (this, Ficha_paciente_pelod::class.java )
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        val int = Intent(this, MainActivity::class.java)
        startActivity(int)
    }
}
