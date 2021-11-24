package com.example.amiiboapp.data

import com.example.amiiboapp.NEW_AMIIBO_ID

data class AmiiboEntity(
    var id: Int,
    var name: String,
    var character: String,
    var game: String
) {
    constructor() : this(NEW_AMIIBO_ID, "", "", "")
    constructor(name: String, character: String, game: String) : this(
        NEW_AMIIBO_ID,
        name,
        character,
        game
    )
}