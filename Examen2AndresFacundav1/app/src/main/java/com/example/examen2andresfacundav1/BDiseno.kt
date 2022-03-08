package com.example.examen2andresfacundav1

import android.os.Parcel
import android.os.Parcelable


class BDiseno (
    val codDiseno: Int,
    var modeloDiseno: String?,
    var precioDiseno: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(codDiseno)
        parcel.writeString(modeloDiseno)
        parcel.writeString(precioDiseno)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BDiseno> {
        override fun createFromParcel(parcel: Parcel): BDiseno {
            return BDiseno(parcel)
        }

        override fun newArray(size: Int): Array<BDiseno?> {
            return arrayOfNulls(size)
        }
    }

}