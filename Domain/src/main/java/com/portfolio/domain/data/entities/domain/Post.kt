package com.portfolio.domain.data.entities.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(val id: Int,
                val title: String,
                val body: String,
                val userId: Int)
    : Parcelable