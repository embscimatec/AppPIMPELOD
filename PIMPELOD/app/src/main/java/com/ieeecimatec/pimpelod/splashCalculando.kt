package com.ieeecimatec.pimpelod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashCalculando : AppCompatActivity() {

    private val SLPASH_TIME_OUT:Long = 6000 //equivale a 2s
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_calculando)

        val resultado : Double = intent.getSerializableExtra("resultado") as Double

        Handler().postDelayed({
            val it = Intent(this, Resultados::class.java)
            it.putExtra("resultado", resultado)
            startActivity(it)

            finish()
        }, SLPASH_TIME_OUT)
    }
}
