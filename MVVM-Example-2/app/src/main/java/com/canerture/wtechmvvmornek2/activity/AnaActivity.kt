package com.canerture.wtechmvvmornek2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.canerture.wtechmvvmornek2.R
import com.canerture.wtechmvvmornek2.databinding.ActivityAnaBinding

class AnaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ana)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerViewAna) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.navController)


    }
}