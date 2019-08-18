package com.example.hcapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataResponse {
    @SerializedName("data")
    @Expose
    var data: ArrayList<Datum>? =  null
}
