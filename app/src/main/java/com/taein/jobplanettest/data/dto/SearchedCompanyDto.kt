package com.taein.jobplanettest.data.dto

import com.google.gson.annotations.SerializedName
import com.taein.jobplanettest.data.entity.Company
import java.io.Serializable

data class SearchedCompanyDto (

    //"minimum_interviews": 0,
    var minimum_interviews : Int?,
    //"total_page": 31763,
    var total_page : Int?,
    //"minimum_reviews": 0,
    var minimum_reviews : Int?,
    //"total_count": 317624,
    var total_count: Int?,

    @SerializedName("items")
    val companyDtos : List<CompanyDto>?

): Serializable