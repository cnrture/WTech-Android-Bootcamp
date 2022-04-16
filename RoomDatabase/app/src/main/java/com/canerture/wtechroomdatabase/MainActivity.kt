package com.canerture.wtechroomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var gelirGiderDB: GelirGiderDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gelirGiderDB = GelirGiderDatabase.getirGelirGiderDatabase(this)!!

    }
}