package com.lnd.salon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lnd.salon.domain.CommonUseCase
import com.lnd.salon.presentation.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(private val commonUseCase: CommonUseCase) : ViewModel(){
    lateinit var response: Flow<Resource<ResponseBody>>

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
}