package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash_inicial : AppCompatActivity() {

    //configurando tempo de carregamento
    private val SLPASH_TIME_OUT:Long = 3000 //equivale a 1s
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_inicial)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }, SLPASH_TIME_OUT)
    }
}
