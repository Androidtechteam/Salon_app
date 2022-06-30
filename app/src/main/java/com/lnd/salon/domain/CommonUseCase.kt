package com.lnd.salon.domain

import com.lnd.salon.presentation.common.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonUseCase {
    suspend fun verifyLogin(requestBody: RequestBody): Flow<Resource<ResponseBody>>
}