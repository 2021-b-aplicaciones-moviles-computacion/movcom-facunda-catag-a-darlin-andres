package com.example.examen2andresfacundav1

import android.os.Parcel
import android.os.Parcelable


class ObjDiseno(
    var disenoId: String?,
    var modeloDiseno: String?,
    var precioDiseno: String?,
    var disenadorDiseno: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){
    }

    override fun toString(): String {
        return "${modeloDiseno}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(disenoId)
        parcel.writeString(modeloDiseno)
        parcel.writeString(precioDiseno)
        parcel.writeString(disenadorDiseno)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ObjDiseno> {
        override fun createFromParcel(parcel: Parcel): ObjDiseno {
            return ObjDiseno(parcel)
        }

        override fun newArray(size: Int): Array<ObjDiseno?> {
            return arrayOfNulls(size)
        }
    }
}