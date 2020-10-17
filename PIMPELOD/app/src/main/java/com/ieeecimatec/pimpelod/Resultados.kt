package com.ieeecimatec.pimpelod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*
import java.math.RoundingMode
import java.text.DecimalFormat

class Resultados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultado : Double = intent.getSerializableExtra("resultado") as Double
        val df = DecimalFormat("##.##")
        df.roundingMode = RoundingMode.CEILING

        val resultadoStr = df.format(resultado).toString()

        textView.text = "${resultadoStr}%"
    }
}
