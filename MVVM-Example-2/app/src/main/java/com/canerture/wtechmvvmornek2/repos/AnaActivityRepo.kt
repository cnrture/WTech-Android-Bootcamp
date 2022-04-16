package com.canerture.wtechmvvmornek2.repos

import androidx.lifecycle.MutableLiveData
import com.canerture.wtechmvvmornek2.models.ana.Dizi
import com.canerture.wtechmvvmornek2.models.ana.Film

class AnaActivityRepo {

    var filmlerData = MutableLiveData<ArrayList<Film?>>()
    var dizilerData = MutableLiveData<ArrayList<Dizi?>>()

    init {
        filmlerData = MutableLiveData()
        dizilerData = MutableLiveData()
    }

    fun filmlerDataGetir(): MutableLiveData<ArrayList<Film?>> {
        return filmlerData
    }

    fun diziDataGetir(): MutableLiveData<ArrayList<Dizi?>> {
        return dizilerData
    }

    fun filmYukleRepo(filmlerListe: ArrayList<Film?>) {
        filmlerData.value = filmlerListe
    }

    fun diziYukleRepo(dizilerListe: ArrayList<Dizi?>) {
        dizilerData.value = dizilerListe
    }

}