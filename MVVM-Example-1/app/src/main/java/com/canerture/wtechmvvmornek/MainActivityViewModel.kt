package com.canerture.wtechmvvmornek

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var gelenOgrenciData = MutableLiveData<OgrenciModel>()
    val orepo = OgrenciRepository()

    init {
        gelenOgrenciData = orepo.ogrenciDataGetir()
    }

    fun ogrenciKaydiGonder(ogrenciAdi: String, ogrenciSoyadi: String, notOrtalamasi: String) {
        orepo.ogrenciKayit(ogrenciAdi, ogrenciSoyadi, notOrtalamasi)
    }

}