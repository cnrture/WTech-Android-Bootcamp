package com.canerture.wtechroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gelirgider")
data class GelirGiderModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "gelirgidertur")
    var gelirgidertur: String,

    @ColumnInfo(name = "harcamatur")
    var harcamatur: String,

    @ColumnInfo(name = "miktar")
    var miktar: String,

)
