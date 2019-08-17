package com.example.hcapplication.ui

import com.example.hcapplication.data.model.DataResponse
import com.example.hcapplication.ui.base.MvpView

interface MainMvpView : MvpView {
    fun doGetData(data: DataResponse)
}