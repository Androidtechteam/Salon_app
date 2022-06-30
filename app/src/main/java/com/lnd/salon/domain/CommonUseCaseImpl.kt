package com.lnd.salon.domain

import com.lnd.salon.data.repository.CommonRepository
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonUseCaseImpl @Inject constructor(private val commonRepository: CommonRepository) :
    CommonUseCase {
    override suspend fun verifyLogin(requestBody: RequestBody)=
        commonRepository.verifyLogin(requestBody)
}