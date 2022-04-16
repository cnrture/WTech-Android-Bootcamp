package com.canerture.wtechmvvmornek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.canerture.wtechmvvmornek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.mainActivityObject = this

        viewModel.gelenOgrenciData.observe(this, {
            binding.ogrenciModel = it
        })

    }

    fun ogrenciEkleMA(ogrenciAdi: String, ogrenciSoyadi: String, notOrtalamasi: String) {
        viewModel.ogrenciKaydiGonder(ogrenciAdi, ogrenciSoyadi, notOrtalamasi)
    }
}