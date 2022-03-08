package com.example.examen2andresfacundav1

import android.os.Parcel
import android.os.Parcelable


class ObjDisenador (
    var disenadorId: String?,
    var disenadorNombre: String?,
    var salario: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString(): String {
        return "${disenadorNombre}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(disenadorId)
        parcel.writeString(disenadorNombre)
        parcel.writeString(salario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ObjDisenador> {
        override fun createFromParcel(parcel: Parcel): ObjDisenador {
            return ObjDisenador(parcel)
        }

        override fun newArray(size: Int): Array<ObjDisenador?> {
            return arrayOfNulls(size)
        }
    }
}