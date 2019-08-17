package com.example.hcapplication.di.component

import com.example.hcapplication.HCApplication
import com.example.hcapplication.di.module.ActivityBindingModule
import com.example.hcapplication.di.module.ApplicationModule
import com.example.hcapplication.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(cayenneApplication: HCApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(cayenneApplication: HCApplication)

}