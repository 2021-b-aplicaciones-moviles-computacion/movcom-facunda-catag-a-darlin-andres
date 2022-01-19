package com.example.examenandresfacunda

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class ObjDisenador(
    var id: Int,
    var nombre: String?,
    var edad: Int,
    var afiliado: Boolean,
    var popularidad: Double,


): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble()
    ) {
    }

    override fun toString(): String {
        return "${id} ${nombre} ${edad} ${afiliado} ${popularidad}"
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt( id )
        p0?.writeString( nombre )
        p0?.writeValue(edad)
        p0?.writeBoolean( afiliado )
        p0?.writeDouble( popularidad )
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