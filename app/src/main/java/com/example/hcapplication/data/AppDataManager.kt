package com.example.hcapplication.data

import javax.inject.Inject

class AppDataManager @Inject
constructor(private val appApiHelper: AppApiHelper) :
    DataManager {
    override fun getData()=
        appApiHelper.getData()

}