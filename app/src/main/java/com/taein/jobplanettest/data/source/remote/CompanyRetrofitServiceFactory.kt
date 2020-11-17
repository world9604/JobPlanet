package com.taein.jobplanettest.data.source.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CompanyRetrofitServiceFactory {

    val JOB_PLANET_BASE_URL = "https://jpassets.jobplanet.co.kr/"
    val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
//    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(JOB_PLANET_BASE_URL)
        .build()

    fun create(): CompanyService {
        return retrofit.create<CompanyService>(CompanyService::class.java)
    }
}