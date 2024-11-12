package com.example.intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Person (
    var nama : String,
    var umur : Int,
    var tinggi : Double
):Parcelable
