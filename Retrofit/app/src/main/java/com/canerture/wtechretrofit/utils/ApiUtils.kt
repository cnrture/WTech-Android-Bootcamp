package com.canerture.wtechretrofit.utils

import com.canerture.wtechretrofit.data.retrofit.YapilacaklarDAOInterface
import com.canerture.wtechretrofit.data.retrofit.RetrofitClient

class ApiUtils {

    companion object {

        private const val BASE_URL = "http://wtech.canerture.com/yapilacaklar/"

        fun getYapilacaklarDAOInterface(): YapilacaklarDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(YapilacaklarDAOInterface::class.java)
        }

    }

}