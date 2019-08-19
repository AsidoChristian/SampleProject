package com.example.hcapplication.ui.adapter

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hcapplication.R
import com.example.hcapplication.data.model.Item
import com.example.hcapplication.ui.base.OnLoadMoreListener

class ArticleAdapter(
    recyclerView: RecyclerView,
    private val mContext: Context,
    private val articleResponse: ArrayList<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItemClickListener: OnItemClickListener? = null
    private var onLoadMoreListener: OnLoadMoreListener? = null
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0
    private var isLoading: Boolean = false
    private val visibleThreshold = 5
    private val VIEW_TYPE_ITEM = 0

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var title: TextView = itemView.findViewById(R.id.textView_recyclerView_title)
        internal var cover: ImageView = itemView.findViewById(R.id.imageView_recyclerView_coverArticle)
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (mItemClickListener != null) {
                mItemClickListener!!.onItemClick(v, layoutPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_ITEM
    }

    fun setOnLoadMoreListener(mOnLoadMoreListener: OnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener
    }


    fun SetOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }


    init {
        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManager!!.itemCount
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener!!.onLoadMore()
                    }
                    isLoading = true
                }
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_list, parent, false)
        return MyViewHolder(view)

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            val item = articleResponse[position]
            holder.title.text = item.articleTitle

            Glide.with(mContext)
                .load(item.articleImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.cover)


            holder.itemView.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(item.link.toString()))
                mContext.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int {
        return articleResponse.size

    }
}