package com.ieeecimatec.pim2pelod2.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ieeecimatec.pim2pelod2.PIM
import com.ieeecimatec.pim2pelod2.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import kotlinx.android.synthetic.main.fragment_gallery.view.buttonPIM


class GalleryFragment : Fragment() {


    override fun onCreateView(Layoutinflater: LayoutInflater,
                              container: ViewGroup?, savedInstantState: Bundle?): View? {
        val view =  Layoutinflater.inflate(R.layout.fragment_gallery, container, false)

        view.buttonPIM.setOnClickListener{ view ->
            val intent = Intent (this.context, PIM::class.java )
            startActivity(intent)
        }

        return view
    }

    fun clickPIM (view : View){
        val intent = Intent (this.context, PIM::class.java )
        startActivity(intent)
    }

}
