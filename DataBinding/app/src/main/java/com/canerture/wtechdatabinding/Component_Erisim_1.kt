package com.canerture.wtechdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityComponentErisim1Binding

class Component_Erisim_1 : AppCompatActivity() {

    private lateinit var binding: ActivityComponentErisim1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_component_erisim_1)

        binding.hesaplaButton.setOnClickListener {

            val birinciSayi = binding.birinciSayiEditText.text.toString().toInt()
            val ikinciSayi = binding.ikinciSayiEditText.text.toString().toInt()

            val ortalama = (birinciSayi + ikinciSayi) / 2

            binding.sonucText.text = ortalama.toString()

        }
    }
}