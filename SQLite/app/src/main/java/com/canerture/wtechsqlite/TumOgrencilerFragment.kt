package com.canerture.wtechsqlite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.canerture.wtechsqlite.databinding.FragmentTumOgrencilerBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class TumOgrencilerFragment : Fragment() {

    private lateinit var binding: FragmentTumOgrencilerBinding
    private lateinit var veriTabani: Veritabani

    private lateinit var ogrenciList: ArrayList<OgrenciModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        veriTabani = Veritabani(requireContext())
        ogrenciList = ArrayList()
        veriTabani.tumOgrencileriAl(ogrenciList)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTumOgrencilerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ogrenciList.isEmpty()) {
            Snackbar.make(view, "Kayıtlı Öğrenci Bulunamadı!", 1000).show()
        }   else {

            ogrenciYazdir(0, binding.ogrenci1AdSoyad, binding.ogrenci1Mail, binding.ogrenci1OgrNo, binding.ogrenci1Gorsel)
            ogrenciYazdir(1, binding.ogrenci2AdSoyad, binding.ogrenci2Mail, binding.ogrenci2OgrNo, binding.ogrenci2Gorsel)
            ogrenciYazdir(2, binding.ogrenci3AdSoyad, binding.ogrenci3Mail, binding.ogrenci3OgrNo, binding.ogrenci3Gorsel)
            ogrenciYazdir(3, binding.ogrenci4AdSoyad, binding.ogrenci4Mail, binding.ogrenci4OgrNo, binding.ogrenci4Gorsel)

        }

        binding.ogrenci1SilButton.ogrenciSil(0)
        binding.ogrenci2SilButton.ogrenciSil(1)
        binding.ogrenci3SilButton.ogrenciSil(2)
        binding.ogrenci4SilButton.ogrenciSil(3)

    }

    fun ogrenciYazdir(i: Int, adSoyatText: TextView, mailText: TextView, ogrNoText: TextView, imageView: ImageView) {
        Picasso.get().load(ogrenciList[i].gorsel).into(imageView)
        adSoyatText.text = ogrenciList[i].adSoyad
        mailText.text = ogrenciList[i].mail
        ogrNoText.text = ogrenciList[i].ogrNo
    }

    fun ImageView.ogrenciSil(id: Int) {

        setOnClickListener {
            veriTabani.ogrenciSil(id)
        }

    }
}