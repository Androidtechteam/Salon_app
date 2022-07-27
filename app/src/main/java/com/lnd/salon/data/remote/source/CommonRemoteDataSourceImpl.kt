package com.lnd.salon.data.remote.source

import com.lnd.salon.data.remote.services.ApiServices
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonRemoteDataSourceImpl @Inject constructor(private val apiServices: ApiServices) :
    CommonRemoteDataSource {
    override suspend fun verifyLogin(requestBody: RequestBody): ResponseBody {
        try {
            val responseBody = apiServices.verifyLogin(requestBody)
            return if (responseBody.isSuccessful) {
                responseBody.body()?:throw Exception("No data found.")
            } else {
                throw Exception(responseBody.errorBody()?.string())
            }
        } catch (ex: Exception) {
            throw Exception(ex.localizedMessage)
        }
    }

    override suspend fun registration(requestBody: RequestBody): ResponseBody {
        try{
            val responseBody = apiServices.registration(requestBody)
            return if(responseBody.isSuccessful){
                responseBody.body()?:throw Exception("No data found")
            }else{
                throw Exception(responseBody.errorBody()?.string())
            }
        }catch (ex:Exception){
            throw Exception(ex.localizedMessage)
        }
    }

    override suspend fun services(page: String, count: String): ResponseBody {
        try{
            val responseBody = apiServices.services(page,count)
            return if(responseBody.isSuccessful){
                responseBody.body()?:throw Exception("No data found")
            }else{
                throw Exception(responseBody.errorBody()?.string())
            }
        }catch (ex:Exception){
            throw Exception(ex.localizedMessage)
        }
    }

    override suspend fun branches(page: String, count: String): ResponseBody {
        try {
            val responseBody = apiServices.branches(page, count)
            return if (responseBody.isSuccessful) {
                responseBody.body() ?: throw Exception("No data found")
            } else {
                throw Exception(responseBody.errorBody()?.string())
            }
        }catch (ex:Exception){
            throw Exception(ex.localizedMessage)
        }
    }

 override suspend fun coupons(page: String, count: String): ResponseBody {
        try {
            val responseBody = apiServices.coupons(page, count)
            return if (responseBody.isSuccessful) {
                responseBody.body() ?: throw Exception("No data found")
            } else {
                throw Exception(responseBody.errorBody()?.string())
            }
        }catch (ex:Exception){
            throw Exception(ex.localizedMessage)
        }
    }


}