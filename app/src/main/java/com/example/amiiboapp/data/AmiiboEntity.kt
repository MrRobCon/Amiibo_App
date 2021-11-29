package com.example.amiiboapp.data

import com.example.amiiboapp.NEW_AMIIBO_ID
import android.os.Parcelable
import android.os.Parcel

data class AmiiboEntity(
    var id: Int,
    var name: String?,
    var character: String?,
    var gameSeries: String?
) : Parcelable
{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    constructor() : this(NEW_AMIIBO_ID, "", "", "")
    constructor(name: String, character: String, gameSeries: String, image: String) : this(
        NEW_AMIIBO_ID,
        name,
        character,
        gameSeries
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(character)
        parcel.writeString(gameSeries)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AmiiboEntity> {
        override fun createFromParcel(parcel: Parcel): AmiiboEntity {
            return AmiiboEntity(parcel)
        }

        override fun newArray(size: Int): Array<AmiiboEntity?> {
            return arrayOfNulls(size)
        }
    }
}