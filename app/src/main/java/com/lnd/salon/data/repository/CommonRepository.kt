package com.lnd.salon.data.repository

import com.lnd.salon.presentation.common.Resource
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import okhttp3.ResponseBody

interface CommonRepository {
suspend fun verifyLogin(requestBody: RequestBody): Flow<Resource<ResponseBody>>
}