package com.lnd.salon.data.remote.services

import android.content.Context
import com.lnd.salon.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideHttpClient(
        @ApplicationContext context: Context,
    ): OkHttpClient {

        val requestInterceptor = Interceptor { chain ->
            val builder = chain.request().newBuilder()
//            builder.addHeader("Authorization", "Bearer " + SharedPref.getApiToken())
            return@Interceptor chain.proceed(builder.build())
        }
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
        client.readTimeout(3000, TimeUnit.SECONDS)
        client.connectTimeout(3000, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            client.addInterceptor(logging)
        }
        return client.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val baseUrl = if (BuildConfig.DEBUG) {
            //live url
            "http://54.215.201.217:8089"
        } else {
            //Staging Url
            "http://54.215.201.217:8089"
        }

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }
}