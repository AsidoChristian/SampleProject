package com.example.hcapplication.ui.base

import com.example.hcapplication.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


open class BasePresenter<V : MvpView> @Inject constructor(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) : MvpPresenter<V> {

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        this.mvpView = null
    }

    fun isViewAttached(): Boolean {
        return mvpView != null
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw MvpViewNotAttachedException()
    }

    class MvpViewNotAttachedException :
        RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")
}