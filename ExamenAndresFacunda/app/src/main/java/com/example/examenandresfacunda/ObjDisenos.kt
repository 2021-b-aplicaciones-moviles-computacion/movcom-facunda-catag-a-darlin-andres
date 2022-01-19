package com.example.examenandresfacunda

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class ObjDisenos (
    var id: Int,
    var modelo: String?,
    var exclusivo: Boolean,
    var costo: Double,
    var id_disenador: Int,

    ): Parcelable {

    constructor(parcel: Parcel) : this(
    parcel.readInt(),
    parcel.readString(),
    parcel.readByte() != 0.toByte(),
    parcel.readDouble(),
    parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "${id} ${modelo} ${exclusivo} ${costo} ${id_disenador}"
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt( id )
        p0?.writeString( modelo )
        p0?.writeBoolean( exclusivo )
        p0?.writeDouble( costo )
        p0?.writeInt( id_disenador )
    }

    companion object CREATOR : Parcelable.Creator<ObjDisenos> {
        override fun createFromParcel(parcel: Parcel): ObjDisenos {
            return ObjDisenos(parcel)
        }

        override fun newArray(size: Int): Array<ObjDisenos?> {
            return arrayOfNulls(size)
        }
    }

}