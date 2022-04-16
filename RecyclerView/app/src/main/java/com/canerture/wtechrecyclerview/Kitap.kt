package com.canerture.wtechrecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kitaplar")
data class Kitap(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kitap_id")
    var kitapId: Int = 0,

    @ColumnInfo(name = "kitap_isim")
    var kitapIsim: String,

    @ColumnInfo(name = "kitap_yazari")
    var kitapYazari: String,

    @ColumnInfo(name = "kitap_yayimci")
    var kitapYayimci: String,

    @ColumnInfo(name = "kitap_fiyat")
    var kitapFiyat: String,

    @ColumnInfo(name = "kitap_gorsel_url")
    var kitapGorselUrl: String,

    @ColumnInfo(name = "sepet_durum")
    var sepetDurum: Int = 0,

)