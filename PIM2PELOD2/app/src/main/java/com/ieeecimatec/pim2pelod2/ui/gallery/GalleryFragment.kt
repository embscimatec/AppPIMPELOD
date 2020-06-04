package com.ieeecimatec.pim2pelod2.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation.findNavController
import com.ieeecimatec.pim2pelod2.Ficha_paciente
import com.ieeecimatec.pim2pelod2.MainActivity
import com.ieeecimatec.pim2pelod2.PIM
import com.ieeecimatec.pim2pelod2.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import kotlinx.android.synthetic.main.fragment_gallery.view.buttonPIM
import kotlinx.android.synthetic.main.fragment_gallery.view.buttonPELOD


class GalleryFragment : Fragment() {


    override fun onCreateView(Layoutinflater: LayoutInflater,
                              container: ViewGroup?, savedInstantState: Bundle?): View? {
        val view =  Layoutinflater.inflate(R.layout.fragment_gallery, container, false)


                view.buttonPIM.setOnClickListener{ view ->
            val intent = Intent (this.context, Ficha_paciente::class.java )
                    intent.putExtra("escolha", 1)
            startActivity(intent)
        }
                view.buttonPELOD.setOnClickListener{ view ->
            val intent = Intent (this.context, Ficha_paciente::class.java )
                    intent.putExtra("escolha", 0)
            startActivity(intent)
        }

        return view
    }

    fun clickPIM (view : View){ //esse método nao está funcionando
        val intent = Intent (this.context, Ficha_paciente::class.java )
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        val int = Intent(this.context, MainActivity::class.java)
        startActivity(int)
    }

}
