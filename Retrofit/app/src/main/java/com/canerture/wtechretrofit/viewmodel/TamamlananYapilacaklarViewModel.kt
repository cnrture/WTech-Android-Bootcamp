package com.canerture.wtechretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechretrofit.Repository
import com.canerture.wtechretrofit.model.YapilacakModel

class TamamlananYapilacaklarViewModel: ViewModel() {

    var tamamlananYapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()
    private val repo = Repository()

    init {
        tamamlananYapilacaklariGetirVM()
    }

    fun tamamlananYapilacaklariGetirVM() {
        repo.tamamlananYapilacaklariGetir()
        tamamlananYapilacaklarList = repo.tamamlananYapilacaklarListGetir()
    }

    fun tamamlandiDurumDegistir(id: Int, tamamlandiDurum: Int) {
        repo.tamamlandiDurumDegistir(id, tamamlandiDurum)
    }

    fun onemliDurumDegistir(id: Int, onemliDurum: Int) {
        repo.onemliDurumDegistir(id, onemliDurum)
    }

}