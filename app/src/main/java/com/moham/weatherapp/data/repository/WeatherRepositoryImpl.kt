package com.moham.weatherapp.data.repository

import com.moham.weatherapp.data.mappers.toWeatherInfo
import com.moham.weatherapp.data.remote.WeatherApi
import com.moham.weatherapp.domain.repository.WeatherRepository
import com.moham.weatherapp.domain.util.Resource
import com.moham.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try{
            Resource.Success(data = api.getWeatherData(lat,long).toWeatherInfo())
        }catch (e:Exception){
            e.printStackTrace()
            Resource.Error(message = e.message ?: "An Unkown Error Occured")
        }
    }
}