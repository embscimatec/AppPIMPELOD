package com.ieeecimatec.pim2pelod2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class splash_calculando : AppCompatActivity() {

    private val SLPASH_TIME_OUT:Long = 6000 //equivale a 2s
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
