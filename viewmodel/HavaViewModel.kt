package com.example.havadurumu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.havadurumu.api.NetworkResponse
import com.example.havadurumu.cons.Constant
import com.example.havadurumu.retrofithelper.RetrofitInstance
import com.example.wheaterapp.model.WeatherModel
import kotlinx.coroutines.launch

class HavaViewModel:ViewModel() {
    private val havaApi=RetrofitInstance.havaApi
   private val _havaSonuc=MutableLiveData<NetworkResponse<WeatherModel>>()
    val havaSonuc:LiveData<NetworkResponse<WeatherModel>> = _havaSonuc
    fun getHAva(city:String){
        _havaSonuc.value=NetworkResponse.Loading
        try {
            viewModelScope.launch {
                val response=havaApi.getHava(Constant.apiKey,city)
                if (response.isSuccessful){
                    response.body()?.let {
                        _havaSonuc.value=NetworkResponse.Success(it)
                    }
                }else{
                    _havaSonuc.value=NetworkResponse.Error("Hava sonucu alınamadı...")
                }
            }
        }catch (e:Exception){
            _havaSonuc.value=NetworkResponse.Error("Hava sonucu alınamadı...")
        }

    }
}