package com.example.examen2andresfacundav1

import android.os.Parcel
import android.os.Parcelable


class BDisenador(
    val cedulaDisenador: Int,
    var nombreDisenador: String?,
    var salario: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString():String{
        return "${nombreDisenador}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cedulaDisenador)
        parcel.writeString(nombreDisenador)
        parcel.writeString(salario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BDisenador> {
        override fun createFromParcel(parcel: Parcel): BDisenador {
            return BDisenador(parcel)
        }

        override fun newArray(size: Int): Array<BDisenador?> {
            return arrayOfNulls(size)
        }
    }


}