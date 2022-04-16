package com.canerture.wtechviewmodellivedatarepo

import androidx.lifecycle.MutableLiveData

class Repository {

    var ortalamaSonuc = MutableLiveData<String>()

    init {
        ortalamaSonuc = MutableLiveData("0")
    }

    fun ortalamaSonucGetir(): MutableLiveData<String> {
        return ortalamaSonuc
    }

    fun ortalamaHesaplaRepo(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        val birinciSayi = gelenBirinciSayi.toInt()
        val ikinciSayi = gelenIkinciSayi.toInt()

        val ortalama = (birinciSayi + ikinciSayi) / 2

        ortalamaSonuc.value = ortalama.toString()
    }

}