package com.canerture.wtechrecyclerview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KitaplarDAO {

    @Insert
    fun kitapEkle(kitap: Kitap)

    @Query("SELECT * FROM kitaplar")
    fun tumKitaplar(): List<Kitap>

    @Query("UPDATE kitaplar SET sepet_durum=:sepetDurumInput WHERE kitap_id=:idInput")
    fun sepetDurumGuncelle(idInput: Int, sepetDurumInput: Int)

    @Query("SELECT * FROM kitaplar WHERE sepet_durum = 1")
    fun sepetKitaplar(): List<Kitap>

}