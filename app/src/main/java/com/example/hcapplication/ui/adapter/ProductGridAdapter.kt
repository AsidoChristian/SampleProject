package com.example.hcapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.hcapplication.R
import com.example.hcapplication.data.model.Datum
import com.example.hcapplication.data.model.Item
import kotlinx.android.synthetic.main.products_item.view.*

class ProductGridAdapter : BaseAdapter {
    var productList = ArrayList<Item>()
    var context: Context? = null

    constructor(context: Context, productList: ArrayList<Item>) : super() {
        this.context = context
        this.productList = productList
    }

    override fun getCount(): Int {
        return productList.size
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        println("masuk gann ${productList.size}")
        val product = this.productList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var productView = inflator.inflate(R.layout.products_item, null)
        Glide.with(context!!)
            .load(product.productImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(productView.imgProduct)
        productView.tvName.text = product.productName


        return productView
    }
}
