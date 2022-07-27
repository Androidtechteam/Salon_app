package com.lnd.salon.data.remote.source

import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonRemoteDataSource {

    suspend fun verifyLogin(requestBody: RequestBody): ResponseBody

    suspend fun registration(requestBody: RequestBody): ResponseBody

    suspend fun services(page: String, count: String): ResponseBody

    suspend fun branches(page: String, count: String): ResponseBody

    suspend fun coupons(page: String, count: String): ResponseBody
}