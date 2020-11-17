package com.taein.jobplanettest.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.taein.jobplanettest.data.dto.ThemeDto
import java.io.Serializable

@Entity(tableName = "Theme")
data class Theme (
    //"color": "#f78f09",
    var color : String?,
    //"cover_image": "https://jpassets.jobplanet.co.kr/production/uploads/job/theme/bg_image/34/thumb_theme_06_03app.png",
    var cover_image: String?,
    //"id": 34,
    @PrimaryKey
    var id: Int,
    //"title": "월급 도둑. 공범 모집중."
    var title: String?
) : Serializable {
    companion object {
        @JvmStatic
        fun create(dto : ThemeDto) : Theme {
            return Theme(dto.color, dto.cover_image, dto.id, dto.title)
        }
    }
}