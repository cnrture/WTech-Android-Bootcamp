package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityEventHandle2Binding

class Event_Handle_2 : AppCompatActivity() {

    private lateinit var binding: ActivityEventHandle2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_handle_2)

        binding.eventHandleObject = this

    }

    fun ortalamaHesapla() {

        val birinciSayi = binding.birinciSayiEditText.text.toString().toInt()
        val ikinciSayi = binding.ikinciSayiEditText.text.toString().toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        binding.sonucText.text = ortalama.toString()

    }
}