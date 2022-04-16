package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityXmlIcindeKodlama5Binding

class XML_Icinde_Kodlama_5 : AppCompatActivity() {

    private lateinit var binding: ActivityXmlIcindeKodlama5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_xml_icinde_kodlama_5)

        binding.xmlIcindeKodlamaObject = this

        binding.ortalamaSonuc = "0"
    }

    fun ortalamaHesapla(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        val birinciSayi = gelenBirinciSayi.toInt()
        val ikinciSayi = gelenIkinciSayi.toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        binding.ortalamaSonuc = ortalama.toString()

    }
}