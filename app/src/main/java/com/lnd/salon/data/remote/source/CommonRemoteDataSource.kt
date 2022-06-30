package com.lnd.salon.data.remote.source

import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonRemoteDataSource {

    suspend fun verifyLogin(requestBody: RequestBody): ResponseBody
}