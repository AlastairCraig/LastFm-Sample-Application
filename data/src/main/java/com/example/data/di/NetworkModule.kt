package com.example.data.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getHttpClient())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun getHttpClient(): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .header("api_key", API_KEY)

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        httpClient.addInterceptor(httpLoggingInterceptor)
        return httpClient.build()
    }

    companion object {
        const val BASE_URL = "http://ws.audioscrobbler.com/2.0/"
        const val API_KEY = "4253906b1ff906d327fb847318a29c1f"
    }
}