package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityXmlDegiskenGonderme4Binding

class XML_Degisken_Gonderme_4 : AppCompatActivity() {

    private lateinit var binding: ActivityXmlDegiskenGonderme4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_xml_degisken_gonderme_4)

        binding.xmlDegiskenGondermeObject = this
    }

    fun ortalamaHesapla(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        val birinciSayi = gelenBirinciSayi.toInt()
        val ikinciSayi = gelenIkinciSayi.toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        binding.ortalamaSonuc = ortalama.toString()

    }
}