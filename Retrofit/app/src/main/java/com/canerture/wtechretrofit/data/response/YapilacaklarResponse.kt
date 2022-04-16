package com.canerture.wtechretrofit.data.response

import com.canerture.wtechretrofit.model.YapilacakModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class YapilacaklarResponse(@SerializedName("yapilacaklar")
                                @Expose
                                var yapilacaklar: List<YapilacakModel>,

                                @SerializedName("success")
                                @Expose
                                var success: Int

): Serializable