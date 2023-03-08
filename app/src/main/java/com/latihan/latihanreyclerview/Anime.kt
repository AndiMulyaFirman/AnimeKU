package com.latihan.latihanreyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var name: String,
    var description: String,
    var photo: String
) : Parcelable
