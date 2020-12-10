package com.kreate.mvvmproject.entity

import android.os.Parcel
import android.os.Parcelable

class RequestEntity() : Parcelable{
    var Pipeline_Code: String? = null
    var Region: String? = null
    var Section_Code: String? = null

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RequestEntity> {
        override fun createFromParcel(parcel: Parcel): RequestEntity {
            return RequestEntity(parcel)
        }

        override fun newArray(size: Int): Array<RequestEntity?> {
            return arrayOfNulls(size)
        }
    }
}