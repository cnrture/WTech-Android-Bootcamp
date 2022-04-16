package com.canerture.wtechsqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Veritabani(context: Context): SQLiteOpenHelper(context, "Veriler", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ogrenciler (id INTEGER PRIMARY KEY AUTOINCREMENT, gorsel TEXT, adsoyad TEXT, mail TEXT, ogrno TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun ogrenciEkle(gorselInput: String, adsoyadInput: String, mailInput: String, ogrnoInput: String) {

        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put("gorsel", gorselInput)
        values.put("adsoyad", adsoyadInput)
        values.put("mail", mailInput)
        values.put("ogrno", ogrnoInput)
        db.insert("ogrenciler", null, values)
        db.close()

    }

    fun tumOgrencileriAl(ogrenciListe: ArrayList<OgrenciModel>) {

        val db: SQLiteDatabase = readableDatabase
        val sutunlar = arrayOf("id","gorsel","adsoyad","mail","ogrno")
        val cursor: Cursor = db.query("ogrenciler", sutunlar, null, null, null, null, null)

        val idIx = cursor.getColumnIndex("id")
        val gorselIx = cursor.getColumnIndex("gorsel")
        val adsoyadIx = cursor.getColumnIndex("adsoyad")
        val mailIx = cursor.getColumnIndex("mail")
        val ogrNoIx = cursor.getColumnIndex("ogrno")

        while (cursor.moveToNext()) {
            ogrenciListe.add(OgrenciModel(cursor.getInt(idIx),
                cursor.getString(gorselIx),
                cursor.getString(adsoyadIx),
                cursor.getString(mailIx),
                cursor.getString(ogrNoIx)))
        }
        cursor.close()
        db.close()

    }

    fun ogrenciAra(adSoyadInput: String): OgrenciModel {

        val db: SQLiteDatabase = readableDatabase
        val sonuc = OgrenciModel(0, "", "", "", "")

        val selectQuery = "SELECT * FROM ogrenciler WHERE adsoyad = ?"
        db.rawQuery(selectQuery, arrayOf(adSoyadInput)).use{

            if (it.moveToFirst()) {
                sonuc.id = it.getInt(it.getColumnIndex("id"))
                sonuc.gorsel = it.getString(it.getColumnIndex("gorsel"))
                sonuc.adSoyad = it.getString(it.getColumnIndex("adsoyad"))
                sonuc.mail = it.getString(it.getColumnIndex("mail"))
                sonuc.ogrNo = it.getString(it.getColumnIndex("ogrno"))
            }

        }
        db.close()
        return sonuc
    }

    fun ogrenciSil(idInput: Int) {
        val db: SQLiteDatabase = writableDatabase
        db.delete("ogrenciler", "id=$idInput", null)
        db.close()
    }

    fun ogrencileriTemizle() {
        val db: SQLiteDatabase = writableDatabase
        db.delete("ogrenciler", null, null)
    }

}