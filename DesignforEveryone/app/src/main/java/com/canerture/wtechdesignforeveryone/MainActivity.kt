package com.canerture.wtechdesignforeveryone

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.canerture.wtechdesignforeveryone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preference = getSharedPreferences("darkMode", Context.MODE_PRIVATE)
        val editor = preference.edit()

        val karanlikTemaDurum = preference.getBoolean("karanlikTemaDurum", false)

        if (karanlikTemaDurum) {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            binding.karanlikTemaSwitch.isChecked = true
        }   else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            binding.karanlikTemaSwitch.isChecked = false
        }

        binding.karanlikTemaSwitch.setOnCheckedChangeListener { compoundButton, b ->

            if (b) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                editor.putBoolean("karanlikTemaDurum", true).apply()
            }   else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                editor.putBoolean("karanlikTemaDurum", false).apply()
            }

        }

    }
}