package com.example.breakingbad.data

import android.os.Parcelable
import android.os.Parcel

data class CharacterEntity(
    var char_id: Int,
    var name: String?,
    var nickname: String?,
    var birthday: String?,
    var status: String?,
    var portrayed: String?
) : Parcelable
{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(char_id)
        parcel.writeString(name)
        parcel.writeString(nickname)
        parcel.writeString(birthday)
        parcel.writeString(status)
        parcel.writeString(portrayed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterEntity> {
        override fun createFromParcel(parcel: Parcel): CharacterEntity {
            return CharacterEntity(parcel)
        }

        override fun newArray(size: Int): Array<CharacterEntity?> {
            return arrayOfNulls(size)
        }
    }
}