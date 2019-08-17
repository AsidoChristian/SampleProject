package com.example.hcapplication.ui.base

interface MvpPresenter<V : MvpView>{
    fun onAttach(mvpView: V)
    fun onDetach()
}