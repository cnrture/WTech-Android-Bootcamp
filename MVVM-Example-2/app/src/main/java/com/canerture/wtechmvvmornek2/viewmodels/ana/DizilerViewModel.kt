package com.canerture.wtechmvvmornek2.viewmodels.ana

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechmvvmornek2.models.ana.Dizi
import com.canerture.wtechmvvmornek2.repos.AnaActivityRepo

class DizilerViewModel: ViewModel() {

    val anaRepo = AnaActivityRepo()
    var dizilerData = MutableLiveData<ArrayList<Dizi?>>()

    init {
        dizilerData = anaRepo.diziDataGetir()
    }

    fun filmYukleVM(dizilerListe: ArrayList<Dizi?>) {
        anaRepo.diziYukleRepo(dizilerListe)
    }

}