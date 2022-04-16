package com.canerture.wtechmvvmornek2.viewmodels.giris

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.canerture.wtechmvvmornek2.repos.GirisActivityRepo

class UyeOViewModel: ViewModel() {

    val girisRepo = GirisActivityRepo()
    var uyelikKontrol = MutableLiveData<Int>()

    init {
        uyelikKontrol = girisRepo.uyelikKontrolGetir()
    }

    fun uyeOlVM(adSoyad: String, mailAdres: String, sifre: String) {
        girisRepo.uyeOlRepo(adSoyad, mailAdres, sifre)
    }

}