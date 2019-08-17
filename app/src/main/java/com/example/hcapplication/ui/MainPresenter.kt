package com.example.hcapplication.ui

import com.example.hcapplication.data.DataManager
import com.example.hcapplication.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainPresenter<V : MainMvpView> @Inject constructor(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, compositeDisposable), MainMvpPresenter<V> {
    override fun doGetData() {
        compositeDisposable.add(
            dataManager.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    if (!isViewAttached())
                        return@subscribe
                    mvpView?.hideLoading()
                    if (data.data != null) {
                        mvpView?.doGetData(data!!)
                        println("response data $data")

                    }
                }, { throwable ->
                    if (!isViewAttached())
                        return@subscribe
                    mvpView?.hideLoading()
                    mvpView?.showMessage(throwable.message!!)
                    Timber.e(throwable.message)
                })
        )
    }
}