package com.example.catfactskt

import com.google.gson.annotations.SerializedName

data class CatHolder(
    @SerializedName("data")
    val catResult: List<Cat>) {
}