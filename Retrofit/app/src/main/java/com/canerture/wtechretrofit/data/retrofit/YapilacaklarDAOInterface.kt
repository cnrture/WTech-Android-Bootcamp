package com.canerture.wtechretrofit.data.retrofit

import com.canerture.wtechretrofit.data.response.CRUDResponse
import com.canerture.wtechretrofit.data.response.YapilacaklarResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YapilacaklarDAOInterface {

    @GET("yapilacaklar.php")
    fun yapilacaklariGetir(): Call<YapilacaklarResponse>

    @GET("yapilacaklar_onemli.php")
    fun onemliYapicaklariGetir(): Call<YapilacaklarResponse>

    @GET("yapilacaklar_tamamlanan.php")
    fun tamamlananYapicaklariGetir(): Call<YapilacaklarResponse>

    @POST("yapilacak_ara.php")
    @FormUrlEncoded
    fun yapilacakAra(@Field("yapilacak")
                     yapilacak: String): Call<YapilacaklarResponse>

    @POST("yapilacak_ekle.php")
    @FormUrlEncoded
    fun yapilacakEkle(@Field("yapilacak") yapilacak: String,
                      @Field("onemli_durum") onemliDurum: Int): Call<CRUDResponse>

    @POST("yapilacak_onemli_durum_degistir.php")
    @FormUrlEncoded
    fun yapilacakOnemliDurumDegistir(@Field("id") id: Int,
                                     @Field("onemli_durum") onemliDurum: Int): Call<CRUDResponse>

    @POST("yapilacak_tamamlandi_durum_degistir.php")
    @FormUrlEncoded
    fun yapilacakTamamlandiDurumDegistir(@Field("id") id: Int,
                                     @Field("tamamlandi_durum") tamamlandiDurum: Int): Call<CRUDResponse>

    @POST("yapilacak_sil.php")
    @FormUrlEncoded
    fun yapilacakSil(@Field("id") id: Int): Call<CRUDResponse>

}