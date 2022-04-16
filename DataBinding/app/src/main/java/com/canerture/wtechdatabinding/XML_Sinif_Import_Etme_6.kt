package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityXmlSinifImportEtme6Binding

class XML_Sinif_Import_Etme_6 : AppCompatActivity() {

    private lateinit var binding: ActivityXmlSinifImportEtme6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_xml_sinif_import_etme_6)

        binding.xmlSinifImportEtmeObject = this

        binding.ortalamaSonuc = "0"
    }

    fun ortalamaHesapla(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        val birinciSayi = gelenBirinciSayi.toInt()
        val ikinciSayi = gelenIkinciSayi.toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        binding.ortalamaSonuc = ortalama.toString()

    }
}