package com.canerture.wtechretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class YapilacakModel(@SerializedName("id")
                          @Expose
                          var id: Int,

                          @SerializedName("yapilacak")
                          @Expose
                          var yapilacak: String,

                          @SerializedName("onemli_durum")
                          @Expose
                          var onemliDurum: Int,

                          @SerializedName("tamamlandi_durum")
                          @Expose
                          var tamamlandiDurum: Int,
): Serializable
