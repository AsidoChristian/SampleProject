package com.example.hcapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hcapplication.R
import com.example.hcapplication.data.model.DataResponse
import com.example.hcapplication.ui.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity(),MainMvpView {

    @Inject
    lateinit var presenter: MainMvpPresenter<MainMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        presenter.doGetData()
    }

    override fun doGetData(data: DataResponse) {
        println("test $data")
    }
}
