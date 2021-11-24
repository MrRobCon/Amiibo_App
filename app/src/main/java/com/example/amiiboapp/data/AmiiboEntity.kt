package com.example.amiiboapp.data

import com.example.amiiboapp.NEW_AMIIBO_ID

data class AmiiboEntity(
    var id: Int,
    var name: String,
    var character: String,
    var gameSeries: String,
    val image: String
) {
    constructor() : this(NEW_AMIIBO_ID, "", "", "", "")
    constructor(name: String, character: String, game: String, image: String) : this(
        NEW_AMIIBO_ID,
        name,
        character,
        game,
        image
    )
}