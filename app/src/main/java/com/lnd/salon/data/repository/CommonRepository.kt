package com.lnd.salon.data.repository

import com.lnd.salon.presentation.common.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonRepository {
    suspend fun verifyLogin(requestBody: RequestBody): Flow<Resource<ResponseBody>>

    suspend fun registration(requestBody: RequestBody): Flow<Resource<ResponseBody>>

    suspend fun services(page:String,count:String): Flow<Resource<ResponseBody>>

    suspend fun branches(page:String,count:String): Flow<Resource<ResponseBody>>

    suspend fun coupons(page:String,count:String): Flow<Resource<ResponseBody>>

    suspend fun categories():Flow<Resource<ResponseBody>>

    suspend fun beautyTips():Flow<Resource<ResponseBody>>

}