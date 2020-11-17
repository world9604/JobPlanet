package com.taein.jobplanettest.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taein.jobplanettest.data.dto.DeadLineDto
import java.io.Serializable


data class DeadLine(
    //"color": "gray",
    var color : String?,
    //"message": "마감",
    var message: String?,
    //"type": "CLOSED",
    var type : String?,
    //"hex_color": "#7c8b97"
    var hex_color: String?
) : Serializable {
    companion object {
        @JvmStatic
        fun create(dto : DeadLineDto?) : DeadLine {
            return if (dto != null) {
                DeadLine(dto.color, dto.message, dto.type, dto.hex_color)
            } else {
                DeadLine("", "", "", "")
            }
        }
    }
}