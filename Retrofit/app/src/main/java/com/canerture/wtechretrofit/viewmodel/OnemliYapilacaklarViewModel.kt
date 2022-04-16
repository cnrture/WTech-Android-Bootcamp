package com.canerture.wtechretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechretrofit.Repository
import com.canerture.wtechretrofit.model.YapilacakModel

class OnemliYapilacaklarViewModel: ViewModel() {

    var onemliYapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()
    private val repo = Repository()

    init {
        onemliYapilacaklariGetirVM()
    }

    fun onemliYapilacaklariGetirVM() {
        repo.onemliYapilacaklariGetir()
        onemliYapilacaklarList = repo.onemliYapilacaklarListGetir()
    }

    fun onemliDurumDegistir(id: Int, onemliDurum: Int) {
        repo.onemliDurumDegistir(id, onemliDurum)
    }

    fun tamamlandiDurumDegistir(id: Int, tamamlandiDurum: Int) {
        repo.tamamlandiDurumDegistir(id, tamamlandiDurum)
    }

}