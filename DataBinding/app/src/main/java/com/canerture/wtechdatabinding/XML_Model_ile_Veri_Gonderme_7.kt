package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityXmlModelIleVeriGonderme7Binding

class XML_Model_ile_Veri_Gonderme_7 : AppCompatActivity() {

    private lateinit var binding: ActivityXmlModelIleVeriGonderme7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_xml_model_ile_veri_gonderme7)

        binding.kullaniciModel = KullaniciModel("Caner", "Türe", 24)

    }
}