package com.example.hcapplication.data.network

import com.example.hcapplication.data.model.DataResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("/home")
    fun doGetData(): Observable<DataResponse>
}