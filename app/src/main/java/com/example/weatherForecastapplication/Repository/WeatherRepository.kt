package com.example.weatherForecastapplication.Repository


import com.example.weatherForecastapplication.Model.City
import com.example.weatherForecastapplication.Network.ApiServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiServiceImp: ApiServiceImp) {

    fun getCityData(city:String):Flow<City> = flow {
        val response= apiServiceImp.getCity(city,"a45bda185288cef6b03035dd614f61b1")
        emit(response)
    }.flowOn(Dispatchers.IO)
        .conflate()
}