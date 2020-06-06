package com.ieeecimatec.pim2pelod2.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ieeecimatec.pim2pelod2.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*


class GalleryFragment : Fragment() {


    override fun onCreateView(Layoutinflater: LayoutInflater,
                              container: ViewGroup?, savedInstantState: Bundle?): View? {
        val view =  Layoutinflater.inflate(R.layout.fragment_gallery, container, false)


                view.buttonPIM.setOnClickListener{ view ->
            val pagina = Intent (this.context, Ficha_paciente_pim::class.java )

            startActivity(pagina)
        }
                view.buttonPELOD.setOnClickListener{ view ->
            val pagina = Intent (this.context, Ficha_paciente_PELOD::class.java )

            startActivity(pagina)
        }

        return view
    }

    fun clickPIM (view : View){ //esse método nao está funcionando
        val intent = Intent (this.context, Ficha_paciente_pim::class.java )
        startActivity(intent)
    }

    fun clickPELOD (view : View){ //esse método nao está funcionando
        val intent = Intent (this.context, Ficha_paciente_PELOD::class.java )
        startActivity(intent)
    }


    fun onBackPressed(view: View){
        val int = Intent(this.context, MainActivity::class.java)
        startActivity(int)
    }

}
