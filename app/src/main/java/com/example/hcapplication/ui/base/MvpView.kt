package com.example.hcapplication.ui.base

interface MvpView {

    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)

    fun showError(message: String)
}