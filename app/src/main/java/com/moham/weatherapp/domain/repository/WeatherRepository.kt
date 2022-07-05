package com.moham.weatherapp.domain.repository

import com.moham.weatherapp.domain.util.Resource
import com.moham.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat:Double,long:Double):Resource<WeatherInfo>
}