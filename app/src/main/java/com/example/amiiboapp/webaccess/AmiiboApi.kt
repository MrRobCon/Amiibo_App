package com.example.amiiboapp.webaccess

import com.example.amiiboapp.data.AmiiboEntity
import retrofit2.http.GET

interface AmiiboApi {
    @GET("/api/amiibo/?type=card")
    suspend fun getAmiibo() : List<AmiiboEntity>
}