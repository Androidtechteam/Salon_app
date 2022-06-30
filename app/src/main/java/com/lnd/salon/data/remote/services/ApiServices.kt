package com.lnd.salon.data.remote.services

import androidx.annotation.Keep
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {
    @Keep
    @POST("/v3/api-docs/authenticateMobile")
    suspend fun verifyLogin(@Body requestBody: RequestBody?): Response<ResponseBody>
}