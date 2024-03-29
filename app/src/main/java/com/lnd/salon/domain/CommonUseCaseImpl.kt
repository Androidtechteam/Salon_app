package com.lnd.salon.domain

import com.lnd.salon.data.repository.CommonRepository
import com.lnd.salon.presentation.common.Resource
import com.lnd.salon.presentation.models.Branches.BranchesResponseModel
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import com.lnd.salon.presentation.models.NearSaloons.NearBySaloon
import com.lnd.salon.presentation.models.SaloonDetails.SaloonDetailsModel
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

    override suspend fun branches(page: String, count: String): Flow<Resource<BranchesResponseModel>> =
        commonRepository.branches(page, count)

    override suspend fun coupons(page: String, count: String) =
        commonRepository.coupons(page, count)

    override suspend fun categories(): Flow<Resource<CategoriesResponseModel>> =
        commonRepository.categories()

    override suspend fun beautyTips() =
        commonRepository.beautyTips()

    override suspend fun nearBySaloons(): Flow<Resource<NearBySaloon>> =
        commonRepository.nearBySaloons()

    override suspend fun saloonSummary(id:String): Flow<Resource<SaloonDetailsModel>> =
        commonRepository.saloonSummary(id)
}