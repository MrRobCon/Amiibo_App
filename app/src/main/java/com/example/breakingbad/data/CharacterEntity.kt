package com.example.breakingbad.data

import com.example.breakingbad.NEW_CHARACTER_ID
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

    constructor() : this(NEW_CHARACTER_ID, "", "", "", "", "")
    constructor(name: String, nickname: String, birthday: String, status: String, portrayed: String) : this(
        NEW_CHARACTER_ID,
        name,
        nickname,
        birthday,
        status,
        portrayed
    )

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