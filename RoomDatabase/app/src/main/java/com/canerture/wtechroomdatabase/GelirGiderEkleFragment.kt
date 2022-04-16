package com.canerture.wtechroomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.canerture.wtechroomdatabase.databinding.FragmentGelirGiderEkleBinding
import com.canerture.wtechroomdatabase.databinding.FragmentTumGelirGiderlerBinding

class GelirGiderEkleFragment : Fragment() {

    private lateinit var binding: FragmentGelirGiderEkleBinding

    private lateinit var gelirGiderDB: GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(requireContext())!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGelirGiderEkleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            ekleButton.setOnClickListener {

                val gelirGiderTurInput = gelirGiderTurEditText.text.toString()
                val harcamaTurInput = harcamaTurEditText.text.toString()
                val miktarInput = miktarEditText.text.toString()

                //Veri Ekleme
                gelirGiderDB.gelirGiderDAO().gelirGiderEkle(
                    GelirGiderModel(
                        gelirgidertur = gelirGiderTurInput,
                        harcamatur = harcamaTurInput,
                        miktar = miktarInput))

            }
        }

    }

}