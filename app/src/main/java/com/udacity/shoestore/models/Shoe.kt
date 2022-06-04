package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String?,
    var company: String?,
    var size: Int?,
    var description: String?,
) : Parcelable