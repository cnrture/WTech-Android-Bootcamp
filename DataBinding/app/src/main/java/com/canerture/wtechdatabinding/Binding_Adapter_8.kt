package com.canerture.wtechdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.canerture.wtechdatabinding.databinding.ActivityBindingAdapter8Binding

class Binding_Adapter_8 : AppCompatActivity() {

    private lateinit var binding: ActivityBindingAdapter8Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapter_8)

        binding.kullaniciModel = KullaniciModel("Caner", "Türe", 24)

    }
}