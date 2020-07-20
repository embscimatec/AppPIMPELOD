package com.ieeecimatec.pim2pelod2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }


    fun clickPIM (view : View){ //esse método nao está funcionando
        val intent = Intent (this, ficha_paciente::class.java )
        val escolha : String = "PIM"
        intent.putExtra("escolha", escolha)
        startActivity(intent)
    }

    fun clickPELOD (view : View){ //esse método nao está funcionando
        val intent = Intent (this, ficha_paciente::class.java )
        val escolha = "PELOD"
        intent.putExtra("escolha", escolha)
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        this.finish()
    }
}
