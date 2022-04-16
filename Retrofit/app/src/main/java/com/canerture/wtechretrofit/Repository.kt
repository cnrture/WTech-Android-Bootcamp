package com.canerture.wtechretrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.canerture.wtechretrofit.data.response.CRUDResponse
import com.canerture.wtechretrofit.data.response.YapilacaklarResponse
import com.canerture.wtechretrofit.model.YapilacakModel
import com.canerture.wtechretrofit.utils.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    val yapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()
    val onemliYapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()
    val tamamlananYapilacaklarList = MutableLiveData<ArrayList<YapilacakModel>>()

    fun yapilacaklarListGetir(): MutableLiveData<ArrayList<YapilacakModel>> {
        return yapilacaklarList
    }

    fun onemliYapilacaklarListGetir(): MutableLiveData<ArrayList<YapilacakModel>> {
        return onemliYapilacaklarList
    }

    fun tamamlananYapilacaklarListGetir(): MutableLiveData<ArrayList<YapilacakModel>> {
        return tamamlananYapilacaklarList
    }

    fun yapilacaklariGetir() {

        ApiUtils.getYapilacaklarDAOInterface().yapilacaklariGetir()
            .enqueue(object : Callback<YapilacaklarResponse> {
                override fun onResponse(
                    call: Call<YapilacaklarResponse>,
                    response: Response<YapilacaklarResponse>
                ) {
                    val geciciList = response.body()?.yapilacaklar

                    if (geciciList != null) {
                        yapilacaklarList.value = geciciList as ArrayList<YapilacakModel>
                    } else {
                        yapilacaklarList.value = null
                    }
                }

                override fun onFailure(call: Call<YapilacaklarResponse>, t: Throwable) {

                    if (t.localizedMessage != null) {
                        Log.e("Yapılacaklar Çekme Hatası: ", t.localizedMessage.toString())
                    }
                }
            })

    }

    fun onemliYapilacaklariGetir() {

        ApiUtils.getYapilacaklarDAOInterface().onemliYapicaklariGetir().enqueue(object: Callback<YapilacaklarResponse> {
            override fun onResponse(
                call: Call<YapilacaklarResponse>,
                response: Response<YapilacaklarResponse>
            ) {
                val geciciListe = response.body()?.yapilacaklar

                if (geciciListe != null) {
                    onemliYapilacaklarList.value = geciciListe as ArrayList<YapilacakModel>
                }
            }

            override fun onFailure(call: Call<YapilacaklarResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.e("Önemli Yapılacaklar Çekme Hatası: ", t.localizedMessage.toString())
                }
            }

        })

    }

    fun tamamlananYapilacaklariGetir() {

        ApiUtils.getYapilacaklarDAOInterface().tamamlananYapicaklariGetir().enqueue(object: Callback<YapilacaklarResponse> {
            override fun onResponse(
                call: Call<YapilacaklarResponse>,
                response: Response<YapilacaklarResponse>
            ) {
                val geciciListe = response.body()?.yapilacaklar

                if (geciciListe != null) {
                    tamamlananYapilacaklarList.value = geciciListe as ArrayList<YapilacakModel>
                }
            }

            override fun onFailure(call: Call<YapilacaklarResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.e("Tamamlanan Yapılacaklar Çekme Hatası: ", t.localizedMessage.toString())
                }
            }

        })

    }

    fun onemliDurumDegistir(id: Int, onemliDurum: Int) {

        ApiUtils.getYapilacaklarDAOInterface().yapilacakOnemliDurumDegistir(id, onemliDurum).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Önemli Durum Değiştirildi: ", response.body()?.message.toString())
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                if (t.localizedMessage != null) {
                    Log.e("Önemli Durum Değiştirilemedi: ", t.localizedMessage.toString())
                }
            }

        })

    }

    fun tamamlandiDurumDegistir(id: Int, tamamlandiDurum: Int) {

        ApiUtils.getYapilacaklarDAOInterface().yapilacakTamamlandiDurumDegistir(id, tamamlandiDurum).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Tamamlandı Durum Değiştirildi: ", response.body()?.message.toString())
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e("Tamamlandı Durum Değiştirilemedi: ", t.localizedMessage.toString())
            }

        })

    }

    fun yapilacakEkle(yapilacak: String, onemliDurum: Int) {

        ApiUtils.getYapilacaklarDAOInterface().yapilacakEkle(yapilacak, onemliDurum).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Ekleme Başarılı: ", response.body()?.message.toString())
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e("Ekleme Başarısız: ", t.localizedMessage.toString())
            }

        })

    }

    fun yapilacakSil(id: Int) {

        ApiUtils.getYapilacaklarDAOInterface().yapilacakSil(id).enqueue(object: Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                Log.e("Silme Başarılı: ", response.body()?.message.toString())
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                Log.e("Silme Başarısız: ", t.localizedMessage.toString())
            }

        })

    }

}