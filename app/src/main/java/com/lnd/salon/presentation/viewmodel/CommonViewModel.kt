package com.lnd.salon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnd.salon.domain.CommonUseCase
import com.lnd.salon.presentation.common.Resource
import com.lnd.salon.presentation.models.Branches.BranchesResponseModel
import com.lnd.salon.presentation.models.Categories.CategoriesResponseModel
import com.lnd.salon.presentation.models.NearSaloons.NearBySaloon
import com.lnd.salon.presentation.models.SaloonDetails.SaloonDetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(private val commonUseCase: CommonUseCase) : ViewModel(){
    lateinit var response: Flow<Resource<ResponseBody>>
    lateinit var categoriesResponse: Flow<Resource<CategoriesResponseModel>>
    lateinit var branchesResponse: Flow<Resource<BranchesResponseModel>>
    lateinit var saloonResponse: Flow<Resource<NearBySaloon>>
    lateinit var saloonDetailsResponse: Flow<Resource<SaloonDetailsModel>>

    fun getLoginResponse(requestBody: RequestBody) {
        viewModelScope.launch {
            response = commonUseCase.verifyLogin(requestBody)
        }
    }

    fun registration(requestBody: RequestBody){
        viewModelScope.launch {
            response = commonUseCase.registration(requestBody)
        }
    }

    fun categories(){
        viewModelScope.launch {
            categoriesResponse = commonUseCase.categories()
        }
    }

    fun coupons(page: String, count: String){
        viewModelScope.launch {
            response = commonUseCase.coupons(page,count)
        }
    }

    fun branches(page: String, count: String){
        viewModelScope.launch {
            branchesResponse = commonUseCase.branches(page,count)
        }
    }

    fun beautyTips(){
        viewModelScope.launch {
            response = commonUseCase.beautyTips()
        }
    }

    fun nearBySaloons(){
        viewModelScope.launch {
            saloonResponse = commonUseCase.nearBySaloons()
        }
    }

    fun saloonSummary(id:String){
        viewModelScope.launch {
            saloonDetailsResponse = commonUseCase.saloonSummary(id)
        }
    }

}