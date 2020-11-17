package com.taein.jobplanettest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class DeadLineDto(
    //"color": "gray",
    var color : String?,
    //"message": "마감",
    var message: String?,
    //"type": "CLOSED",
    var type : String?,
    //"hex_color": "#7c8b97"
    var hex_color: String?
) : Serializable