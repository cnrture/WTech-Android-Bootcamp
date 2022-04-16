package com.canerture.wtechretrofit.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CRUDResponse(@SerializedName("success")
                        @Expose
                        var success: Int,

                        @SerializedName("message")
                        @Expose
                        var message: String,

): Serializable
