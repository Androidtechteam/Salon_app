package com.lnd.salon.data.repository

import com.lnd.salon.data.remote.source.CommonRemoteDataSource
import com.lnd.salon.presentation.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonRepositoryImpl @Inject constructor(private val commonRemoteDataSource: CommonRemoteDataSource) :
    CommonRepository {
    override suspend fun verifyLogin(requestBody: RequestBody) =
        flow {
            emit(Resource.loading(null))
            try {
                val data = commonRemoteDataSource.verifyLogin(requestBody)
                emit(Resource.success(data))
            } catch (ex: Exception) {
                emit(Resource.error(ex.message ?: "", null))
            }
        }

    override suspend fun registration(requestBody: RequestBody) =
        flow {
            emit(Resource.loading(null))
            try {
                val data = commonRemoteDataSource.registration(requestBody)
                emit(Resource.success(data))
            } catch (ex: Exception) {
                emit(Resource.error(ex.message ?: "", null))
            }
        }

    override suspend fun services(page: String, count: String) =
        flow {
            emit(Resource.loading(null))
            try {
                val data = commonRemoteDataSource.services(page, count)
                emit(Resource.success(data))
            } catch (ex: Exception) {
                emit(Resource.error(ex.message ?: "", null))
            }
        }

    override suspend fun branches(page: String, count: String) =
        flow {
            emit(Resource.loading(null))
            try {
                val data = commonRemoteDataSource.branches(page, count)
                emit(Resource.success(data))
            } catch (ex: Exception) {
                emit(Resource.error(ex.message ?: "", null))
            }
        }

    override suspend fun coupons(page: String, count: String) =
        flow {
            emit(Resource.loading(null))
            try {
                val data = commonRemoteDataSource.branches(page, count)
                emit(Resource.success(data))
            } catch (ex: Exception) {
                emit(Resource.error(ex.message ?: "", null))
            }
        }

    override suspend fun categories() =
        flow {
            emit(Resource.loading(null))
            try{
                val data = commonRemoteDataSource.categories()
                emit(Resource.success(data))
            }catch (ex:Exception){
                emit(Resource.error(ex.message ?: "",null))
            }
        }

    override suspend fun beautyTips() =
        flow {
            emit(Resource.loading(null))
            try{
                val data = commonRemoteDataSource.beautyTips()
                emit(Resource.success(data))
            }catch (ex:Exception){
                emit(Resource.error(ex.message ?: "",null))
            }
        }
}