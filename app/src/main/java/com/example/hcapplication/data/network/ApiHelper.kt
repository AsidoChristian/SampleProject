package com.example.hcapplication.data.network

import com.example.hcapplication.data.model.DataResponse
import io.reactivex.Observable

interface ApiHelper {
    fun getData(): Observable<DataResponse>
}