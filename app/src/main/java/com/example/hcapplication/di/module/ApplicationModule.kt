package com.example.hcapplication.di.module

import android.app.Application
import android.content.Context
import com.example.hcapplication.HCApplication
import com.example.hcapplication.data.AppApiHelper
import com.example.hcapplication.data.AppDataManager
import com.example.hcapplication.data.Config
import com.example.hcapplication.data.DataManager
import com.example.hcapplication.data.network.ApiHelper
import com.example.hcapplication.di.ApplicationContext
import com.example.hcapplication.di.BaseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(cayenneApplication: HCApplication): Context {
        return cayenneApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(cayenneApplication: HCApplication): Application {
        return cayenneApplication
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }


    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}