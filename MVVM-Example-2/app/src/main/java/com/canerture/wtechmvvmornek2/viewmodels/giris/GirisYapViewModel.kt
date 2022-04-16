package com.canerture.wtechmvvmornek2.viewmodels.giris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechmvvmornek2.models.giris.Kullanici
import com.canerture.wtechmvvmornek2.repos.GirisActivityRepo

class GirisYapViewModel: ViewModel() {

    val girisRepo = GirisActivityRepo()
    var kullaniciData = MutableLiveData<Kullanici?>()

    init {
        kullaniciData = girisRepo.kullaniciDataGetir()
    }

    fun girisYapVM(adSoyad: String, mailAdres: String, sifre: String) {
        girisRepo.girisYapRepo(adSoyad, mailAdres, sifre)
    }

}