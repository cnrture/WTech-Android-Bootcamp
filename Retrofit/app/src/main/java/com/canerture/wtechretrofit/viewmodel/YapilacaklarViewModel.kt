package com.canerture.wtechretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechretrofit.Repository
import com.canerture.wtechretrofit.model.YapilacakModel

class YapilacaklarViewModel: ViewModel() {

    var yapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()
    val repo = Repository()

    init {
        yapilacaklariGetirVM()
    }

    fun yapilacaklariGetirVM() {
        repo.yapilacaklariGetir()
        yapilacaklarList = repo.yapilacaklarListGetir()
    }

    fun onemliDurumDegistir(id: Int, onemliDurum: Int) {
        repo.onemliDurumDegistir(id, onemliDurum)
    }

    fun tamamlandiDurumDegistir(id: Int, tamamlandiDurumDegistir: Int) {
        repo.tamamlandiDurumDegistir(id, tamamlandiDurumDegistir)
    }

    fun yapilacakSil(id: Int) {
        repo.yapilacakSil(id)
    }

}