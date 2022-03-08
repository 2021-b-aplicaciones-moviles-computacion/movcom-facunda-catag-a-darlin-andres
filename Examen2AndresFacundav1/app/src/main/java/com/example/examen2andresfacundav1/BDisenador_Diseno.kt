package com.example.examen2andresfacundav1

import android.os.Parcel
import android.os.Parcelable


class BDisenador_Diseno (
    val cedulaDisenador: Int,
    val codDiseno: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cedulaDisenador)
        parcel.writeInt(codDiseno)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BDisenador_Diseno> {
        override fun createFromParcel(parcel: Parcel): BDisenador_Diseno {
            return BDisenador_Diseno(parcel)
        }

        override fun newArray(size: Int): Array<BDisenador_Diseno?> {
            return arrayOfNulls(size)
        }
    }
}