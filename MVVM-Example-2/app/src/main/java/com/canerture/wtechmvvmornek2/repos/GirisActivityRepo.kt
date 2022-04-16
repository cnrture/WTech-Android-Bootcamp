package com.canerture.wtechmvvmornek2.repos

import androidx.lifecycle.MutableLiveData
import com.canerture.wtechmvvmornek2.models.giris.Kullanici

class GirisActivityRepo {

    var kullaniciData = MutableLiveData<Kullanici?>()
    var uyelikKontrol = MutableLiveData<Int>()

    init {
        kullaniciData = MutableLiveData()
        uyelikKontrol = MutableLiveData()
    }

    fun kullaniciDataGetir(): MutableLiveData<Kullanici?> {
        return kullaniciData
    }

    fun uyelikKontrolGetir(): MutableLiveData<Int> {
        return uyelikKontrol
    }

    fun girisYapRepo(adSoyad: String, mailAdres: String, sifre: String) {

        if (adSoyad == "Caner Ture" && mailAdres == "cnrture@gmail.com" && sifre == "caner123") {
            kullaniciData.value = Kullanici(adSoyad, mailAdres, sifre)
        }   else {
            kullaniciData.value = null
        }

    }

    fun uyeOlRepo(adSoyad: String, mailAdres: String, sifre: String) {


        if (adSoyad != "" && mailAdres != "" && sifre != "") {
            uyelikKontrol.value = 1
        }   else {
            uyelikKontrol.value = 0
        }

    }



}