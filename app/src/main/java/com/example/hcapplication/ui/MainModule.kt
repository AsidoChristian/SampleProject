package com.example.hcapplication.ui

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hcapplication.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideNewsMvpPresenter(presenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> {
        return presenter
    }

    @Provides
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}