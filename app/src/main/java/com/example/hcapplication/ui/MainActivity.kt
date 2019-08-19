package com.example.hcapplication.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hcapplication.R
import com.example.hcapplication.data.model.DataResponse
import com.example.hcapplication.data.model.Item
import com.example.hcapplication.ui.adapter.ArticleAdapter
import com.example.hcapplication.ui.adapter.ProductGridAdapter
import com.example.hcapplication.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(),MainMvpView {

    @Inject
    lateinit var presenter: MainMvpPresenter<MainMvpView>
    lateinit var progressDialog: ProgressDialog
    private var gridAdapter: ProductGridAdapter? = null
    private var recAdapter: ArticleAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var modelProduct = ArrayList<Item>()
    private var modelArticle : ArrayList<Item>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView =findViewById(R.id.recyclerView_main_article)
        progressDialog = ProgressDialog(this@MainActivity)
        presenter.onAttach(this)
        progressDialog.setTitle("ProgressDialog")
        progressDialog.setMessage("Loading...")
        progressDialog.show()
        presenter.doGetData()
    }

    override fun doGetData(data: DataResponse) {
        modelProduct= data.data?.get(0)?.items!!
        gridAdapter = ProductGridAdapter(this, modelProduct)
        gridView_main_product.adapter = gridAdapter

        textView_main_sectionTitle.text= data.data!![1].sectionTitle.toString()
        modelArticle= data.data!![1].items
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recAdapter = ArticleAdapter(recyclerView!!,this,modelArticle!!)
        recyclerView?.adapter = recAdapter
        progressDialog.dismiss()
    }
}
