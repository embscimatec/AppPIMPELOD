package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_calculando : AppCompatActivity() {

    private val SLPASH_TIME_OUT:Long = 15000 //equivale a 5s
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_calculando)

        val resultado : Double = intent.getSerializableExtra("resultado") as Double

        Handler().postDelayed({
            val it = Intent(this, Resultado::class.java)
            it.putExtra("resultado", resultado)
            startActivity(it)

            finish()
        }, SLPASH_TIME_OUT)
    }
}
