package com.lnd.salon.di

import com.lnd.salon.data.remote.services.ApiServices
import com.lnd.salon.data.remote.source.CommonRemoteDataSource
import com.lnd.salon.data.remote.source.CommonRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module(includes = [CommonRemoteModule.Binders::class])
class CommonRemoteModule {
    @Module
    @InstallIn(SingletonComponent::class)
    interface Binders{
        @Binds
        fun bindRemoteSource(
            commonRemoteDataSourceImpl: CommonRemoteDataSourceImpl
        ): CommonRemoteDataSource
    }

    @Provides
    fun providesLoginService(retrofit: Retrofit): ApiServices = retrofit.create(ApiServices::class.java)
}