package com.canerture.wtechviewmodellivedatarepo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var ortalamaSonuc = MutableLiveData<String>()
    val repo = Repository()

    init {
        ortalamaSonuc = repo.ortalamaSonucGetir()
    }

    fun ortalamaHesaplaVM(gelenBirinciSayi: String, gelenIkinciSayi: String) {

        repo.ortalamaHesaplaRepo(gelenBirinciSayi, gelenIkinciSayi)

    }

}