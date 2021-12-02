package com.example.breakingbad.webaccess

import com.example.breakingbad.data.CharacterEntity
import retrofit2.http.GET

interface BreakingBadApi {

    @GET("characters")
    suspend fun getCharacters() : List<CharacterEntity>

}