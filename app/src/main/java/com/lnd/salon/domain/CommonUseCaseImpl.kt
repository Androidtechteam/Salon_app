package com.lnd.salon.domain

import com.lnd.salon.data.repository.CommonRepository
import com.lnd.salon.presentation.common.Resource
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonUseCaseImpl @Inject constructor(private val commonRepository: CommonRepository) :
    CommonUseCase {
    override suspend fun verifyLogin(requestBody: RequestBody) =
        commonRepository.verifyLogin(requestBody)

    override suspend fun registration(requestBody: RequestBody) =
        commonRepository.registration(requestBody)

    override suspend fun services(page: String, count: String) =
        commonRepository.services(page, count)

    override suspend fun branches(page: String, count: String) =
        commonRepository.branches(page, count)

    override suspend fun coupons(page: String, count: String) =
        commonRepository.branches(page, count)

    override suspend fun categories(): Flow<Resource<CategoriesResponseModel>> =
        commonRepository.categories()

    override suspend fun beautyTips() =
        commonRepository.beautyTips()
}