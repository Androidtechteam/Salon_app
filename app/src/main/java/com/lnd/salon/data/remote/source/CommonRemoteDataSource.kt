package com.lnd.salon.data.remote.source

import com.lnd.salon.presentation.models.Branches.BranchesResponseModel
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import com.lnd.salon.presentation.models.NearSaloons.NearBySaloon
import com.lnd.salon.presentation.models.SaloonDetails.SaloonDetailsModel
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonRemoteDataSource {

    suspend fun verifyLogin(requestBody: RequestBody): ResponseBody

    suspend fun registration(requestBody: RequestBody): ResponseBody

    suspend fun services(page: String, count: String): ResponseBody

    suspend fun branches(page: String, count: String): BranchesResponseModel

    suspend fun coupons(page: String, count: String): ResponseBody

    suspend fun categories(): CategoriesResponseModel

    suspend fun beautyTips():ResponseBody

    suspend fun nearBySaloons(): NearBySaloon

    suspend fun saloonSummary(id:String): SaloonDetailsModel
}