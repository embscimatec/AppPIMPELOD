package com.ieeecimatec.pimpelod

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    BottomNavigationView.OnNavigationItemReselectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        initBottomNavigation()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initBottomNavigation() {
        bottom_nav_view.setOnNavigationItemSelectedListener( this )
        bottom_nav_view.setOnNavigationItemReselectedListener( this )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /* TODO */
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        /* TODO */
    }

    fun clickPIM (view : View){
        val intent = Intent (this, Ficha_paciente_Pim::class.java )
        startActivity(intent)
    }

    fun clickPELOD (view : View){
        val intent = Intent (this, Ficha_paciente_pelod::class.java )
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        val int = Intent(this, MainActivity::class.java)
        startActivity(int)
    }
}
