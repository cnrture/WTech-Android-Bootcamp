package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityEventHandleWithParameter3Binding

class Event_Handle_With_Parameter_3 : AppCompatActivity() {

    private lateinit var binding: ActivityEventHandleWithParameter3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_handle_with_parameter_3)

        binding.eventHandleObject = this
    }

    fun ortalamaHesapla(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        val birinciSayi = gelenBirinciSayi.toInt()
        val ikinciSayi = gelenIkinciSayi.toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        binding.sonucText.text = ortalama.toString()

    }
}