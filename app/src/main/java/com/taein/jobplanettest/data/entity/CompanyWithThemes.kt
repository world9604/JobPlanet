package com.taein.jobplanettest.data.entity

import android.util.Log
import androidx.room.Embedded
import androidx.room.Relation
import com.taein.jobplanettest.data.dto.CompanyDto
import java.io.Serializable
import java.util.*

data class CompanyWithThemes (
    @Embedded
    var company : Company?,
    @Relation(
        parentColumn = "company_id",
        entityColumn = "id"
    )
    var themes : List<Theme>?
) : Serializable {
    companion object {
        @JvmStatic
        fun create(dto : CompanyDto) : CompanyWithThemes {
            val themes : ArrayList<Theme> = ArrayList(0)
            dto.themes?.forEach {
                themes.add(Theme.create(it))
            }
            return CompanyWithThemes(Company.create(dto), themes)
        }
    }
}