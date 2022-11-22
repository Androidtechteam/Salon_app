package com.lnd.salon.domain

import com.lnd.salon.presentation.common.Resource
import com.lnd.salon.presentation.models.Branches.BranchesResponseModel
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonUseCase {
    suspend fun verifyLogin(requestBody: RequestBody): Flow<Resource<ResponseBody>>

    suspend fun registration(requestBody: RequestBody): Flow<Resource<ResponseBody>>

    suspend fun services(page: String, count: String): Flow<Resource<ResponseBody>>

    suspend fun branches(page: String, count: String): Flow<Resource<BranchesResponseModel>>

    suspend fun coupons(page: String, count: String): Flow<Resource<ResponseBody>>

    suspend fun categories():Flow<Resource<CategoriesResponseModel>>

    suspend fun beautyTips():Flow<Resource<ResponseBody>>
}