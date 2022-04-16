package com.canerture.wtechmvvmornek

import androidx.lifecycle.MutableLiveData

class OgrenciRepository {

    var ogrenciData = MutableLiveData<OgrenciModel>()

    init {
        ogrenciData = MutableLiveData()
    }

    fun ogrenciDataGetir(): MutableLiveData<OgrenciModel> {
        return ogrenciData
    }

    fun ogrenciKayit(ogrenciAdi: String, ogrenciSoyadi: String, notOrtalamasi: String) {
        ogrenciData.value = OgrenciModel(ogrenciAdi, ogrenciSoyadi, notOrtalamasi)
    }

}