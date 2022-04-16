package com.canerture.wtechsqlite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.canerture.wtechsqlite.databinding.FragmentAnaSayfaBinding
import com.canerture.wtechsqlite.databinding.FragmentOgrenciAraBinding
import com.canerture.wtechsqlite.databinding.FragmentOgrenciEkleBinding
import com.squareup.picasso.Picasso

class OgrenciAraFragment : Fragment() {

    private lateinit var binding: FragmentOgrenciAraBinding
    private lateinit var veriTabani: Veritabani

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        veriTabani = Veritabani(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOgrenciAraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.araButton.setOnClickListener {

            val ogrenci : OgrenciModel = veriTabani.ogrenciAra(binding.adSoyadEditText.text.toString())

            Picasso.get().load(ogrenci.gorsel).into(binding.gorsel)
            binding.adSoyadText.text = ogrenci.adSoyad
            binding.mailText.text = ogrenci.mail
            binding.ogrNoText.text = ogrenci.ogrNo

        }

        binding.silButton.setOnClickListener {
            veriTabani.ogrenciSil(2)
        }

    }

}