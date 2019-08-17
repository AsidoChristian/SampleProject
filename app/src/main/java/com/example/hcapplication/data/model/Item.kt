package com.example.hcapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("product_name")
    @Expose
    var productName: String? = null
    @SerializedName("product_image")
    @Expose
    var productImage: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("article_title")
    @Expose
    var articleTitle: String? = null
    @SerializedName("article_image")
    @Expose
    var articleImage: String? = null
}
