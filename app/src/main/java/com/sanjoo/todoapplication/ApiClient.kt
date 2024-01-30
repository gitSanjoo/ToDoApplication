package com.sanjoo.todoapplication

import android.content.Context
import com.sanjoo.todoapplication.data.DashboardResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

object ApiClient {

    fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val builder = OkHttpClient.Builder()
        builder.networkInterceptors().add(httpLoggingInterceptor)
        builder.addInterceptor(
            Interceptor {
                    chain: Interceptor.Chain->
                val original = chain.request()
                val requestBuilder: Request.Builder = original
                    .newBuilder()
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
        )
        return builder.build()
    }

    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl("https://api.inopenapp.com/api/v1/")
            .build()
    }

    fun getApiService(): ApiService {
        return getRetrofit(getOkHttpClient()).create(ApiService::class.java)
    }

    suspend fun getDashboardData(): DashboardResponse? {
        return getApiService().getDashboardData().body()
    }

    interface ApiService {

        @Headers("Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")
        @GET("dashboardNew")
        suspend fun getDashboardData(): Response<DashboardResponse>
    }

}