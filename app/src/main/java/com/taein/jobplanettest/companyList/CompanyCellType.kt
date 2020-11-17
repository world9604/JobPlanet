package com.taein.jobplanettest.companyList

import androidx.room.TypeConverter
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.taein.jobplanettest.data.entity.Company
import java.lang.reflect.Type

enum class CompanyCellType(val viewType: Int, val strType: String) {
    CELL_TYPE_COMPANY(1, "CELL_TYPE_COMPANY"),
    CELL_TYPE_HORIZONTAL_THEME(2, "CELL_TYPE_HORIZONTAL_THEME"),
    CELL_TYPE_INTERVIEW(3, "CELL_TYPE_INTERVIEW"),
    CELL_TYPE_JOB_POSTING(4, "CELL_TYPE_JOB_POSTING"),
    CELL_TYPE_REVIEW(5, "CELL_TYPE_REVIEW"),
    CELL_TYPE_SALARY(6, "CELL_TYPE_SALARY"),
    None(-1, "--");

    companion object {
        @TypeConverter
        @JvmStatic
        fun convertFrom(str: String): CompanyCellType {
            try {
                return valueOf(str)
            } catch (ex : IllegalArgumentException) {
                return None
            }
        }

        @TypeConverter
        @JvmStatic
        fun convertStringFrom(companyCellType: CompanyCellType): String {
            return companyCellType.strType
        }

        @JvmStatic
        fun convertIntFrom(viewType: Int) : CompanyCellType{
            return when (viewType) {
                CELL_TYPE_COMPANY.viewType -> CELL_TYPE_COMPANY
                CELL_TYPE_HORIZONTAL_THEME.viewType -> CELL_TYPE_HORIZONTAL_THEME
                CELL_TYPE_INTERVIEW.viewType -> CELL_TYPE_INTERVIEW
                CELL_TYPE_JOB_POSTING.viewType -> CELL_TYPE_JOB_POSTING
                CELL_TYPE_REVIEW.viewType -> CELL_TYPE_REVIEW
                CELL_TYPE_SALARY.viewType -> CELL_TYPE_SALARY
                else -> None
            }
        }
    }
}

class CompanyTypeAdapter : JsonSerializer<CompanyCellType>, JsonDeserializer<CompanyCellType> {

    val CELL_TYPE = "cell_type"

    override fun serialize(src: CompanyCellType?, typeOfSrc: Type?,
                           context: JsonSerializationContext?): JsonElement {
        val cellType = CompanyCellType.convertStringFrom(src ?: CompanyCellType.None)
        val json = JsonObject()
        json.addProperty(CELL_TYPE, cellType)
        return json
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?,
                             context: JsonDeserializationContext? ): CompanyCellType {
        val cellTypeStr = json?.asString ?: throw NullPointerException("Response Json String is null")
        return CompanyCellType.convertFrom(cellTypeStr)
    }
}