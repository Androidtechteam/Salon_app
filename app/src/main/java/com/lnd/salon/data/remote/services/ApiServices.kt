package com.lnd.salon.data.remote.services

import androidx.annotation.Keep
import com.lnd.salon.presentation.models.Branches.BranchesResponseModel
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import com.lnd.salon.presentation.models.NearSaloons.NearBySaloon
import com.lnd.salon.presentation.models.SaloonDetails.SaloonDetailsModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @Keep
    @POST("users/signin")
    suspend fun verifyLogin(@Body requestBody: RequestBody?): Response<ResponseBody>

    @Keep
    @POST("users")
    suspend fun registration(@Body requestBody: RequestBody?): Response<ResponseBody>

    @Keep
    @GET("categories")
    suspend fun categories(): Response<CategoriesResponseModel>

    @Keep
    @GET("services")
    suspend fun services(
        @Query("page") page: String,
        @Query("size") size: String
    ): Response<ResponseBody>

    @Keep
    @GET("branches")
    suspend fun branches(
        @Query("page") page: String,
        @Query("size") size: String
    ): Response<BranchesResponseModel>

    @Keep
    @GET("coupons")
    suspend fun coupons(
        @Query("page") page: String,
        @Query("size") size: String
    ): Response<ResponseBody>

    @Keep
    @GET("beauty-tips")
    suspend fun beautyTips(): Response<ResponseBody>

    @Keep
    @GET("saloons")
    suspend fun nearBySaloons():Response<NearBySaloon>

    @Keep
    @GET("saloons/summary/{id}")
    suspend fun saloonSummary(@Path(value = "id",encoded = true) id:String):Response<SaloonDetailsModel>
}