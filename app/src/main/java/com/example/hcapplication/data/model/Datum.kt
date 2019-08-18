package com.example.hcapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {
    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("items")
    @Expose
    var items: ArrayList<Item>? = null
    @SerializedName("section_title")
    @Expose
    var sectionTitle: String? = null
}
