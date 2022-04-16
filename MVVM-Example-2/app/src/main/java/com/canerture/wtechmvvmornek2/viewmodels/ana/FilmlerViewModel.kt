package com.canerture.wtechmvvmornek2.viewmodels.ana

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechmvvmornek2.models.ana.Film
import com.canerture.wtechmvvmornek2.repos.AnaActivityRepo
import java.util.ArrayList

class FilmlerViewModel: ViewModel() {

    val anaRepo = AnaActivityRepo()
    var filmlerData = MutableLiveData<ArrayList<Film?>>()

    init {
        filmlerData = anaRepo.filmlerDataGetir()
    }

    fun filmYukleVM(filmlerListe: ArrayList<Film?>) {
        anaRepo.filmYukleRepo(filmlerListe)
    }

}