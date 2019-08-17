package com.example.hcapplication.data

import com.example.hcapplication.data.network.ApiHelper
import com.example.hcapplication.data.network.ApiService
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService) :
    ApiHelper {
    override fun getData() =
        apiService.doGetData()
}