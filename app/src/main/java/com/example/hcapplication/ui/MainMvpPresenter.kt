package com.example.hcapplication.ui

import com.example.hcapplication.ui.base.MvpPresenter

interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V> {
    fun doGetData()
}