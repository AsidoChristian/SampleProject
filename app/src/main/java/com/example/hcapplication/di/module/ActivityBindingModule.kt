package com.example.hcapplication.di.module

import com.example.hcapplication.ui.MainActivity
import com.example.hcapplication.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [(MainModule::class)])
    abstract fun bindMainActivity(): MainActivity
}