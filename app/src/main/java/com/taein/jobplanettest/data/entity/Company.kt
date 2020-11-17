package com.taein.jobplanettest.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.JsonAdapter
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.data.dto.CompanyDto
import java.io.Serializable

@Entity(tableName = "Company")
data class Company (
    // 1
    var ranking : String?,
    // "CELL_TYPE_COMPANY"
    var cell_type : CompanyCellType?,
    // 2.44
    var interview_difficulty : String?,
    // "대교(주)"
    var name : String?,
    // 3483
    var salary_avg : String?,
    // ""
    var web_site : String?,
    // "https://jpassets.jobplanet.co.kr/production/uploads/company/logo/82465/thumb_25.png"
    var logo_path : String?,
    // "회사의 이익 규모에 대해 알고 있나?\r\n본인이 잘 할 수 있는 분야는?\r\n본인은 회사에서 장래 어떤 비전을 갖고 있나?"
    var interview_question : String?,
    // 82465
    @PrimaryKey
    var company_id : Int,
    // "true"
    var has_job_posting : Boolean?,
    // 2.63
    var rate_total_avg : Double?,
    // 500
    var industry_id : Int?,
    // "학습지 시장에서 높은 인지도를 가지고 있으나,\r\n학습지업 자체가 하락세이며 영업압박이 심함"
    var review_summary : String?,
    // "INFO"
    var type : String?,
    // "교육업"
    var industry_name : String?,
    // "173 기업리뷰"
    var simple_desc : String?,


    // job_posting
    /*
    "deadline": {
        "color": "gray",
        "message": "마감",
        "type": "CLOSED",
        "hex_color": "#7c8b97"
    }
    */
    @Embedded(prefix = "deadline_")
    var deadline : DeadLine?,
    //"logo": "https://jpassets.jobplanet.co.kr/production/uploads/company/logo/63862/thumb_146.jpg",
    var logo : String?,
    //"id": 41643,
    var id : Int?,
    //"review_avg_cache": 3.34,
    var review_avg_cache : Double?,
    //"title": "법무팀",
    var title : String?,
    //"label_id": "",
    var label_id : String?,
    //"is_saved": "false",
    var is_saved : Boolean?,
    //"company_name": "엘지생명과학(주)"
    var company_name : String?,


    //review
    //"cons": "지사로써의 한계. 모든 결정 및 책임은 본사로부터 나옴. 너무 비용만을 고려한 의사결정은 회사에 대한 충성도를 떨어 뜨림",
    var cons: String?,
    //"pros": "매니저의 눈치를 거의 안보고 업무만 집중할 수 있는 분위기. 높은 수준의 연봉. 업계 최고의 기술력을 보유하고 있음. 체계화된 프로세스등 배울 것이 많음. 해외의 유능한 엔지니어와의 소통을 통해 느끼고 배울수 있는 기회",
    var pros: String?,


    // "salary_lowest": 3200,
    var salary_lowest : String?,
    // "salary_highest": 7330,
    var salary_highest : String?
) : Serializable {
    companion object {
        @JvmStatic
        fun create(dto : CompanyDto) : Company{
            return Company(dto.ranking, dto.cell_type, dto.interview_difficulty, dto.name, dto.salary_avg,
                dto.web_site, dto.logo_path, dto.interview_question, dto.company_id, dto.has_job_posting,
                dto.rate_total_avg, dto.industry_id, dto.review_summary, dto.type, dto.industry_name,
                dto.simple_desc, DeadLine.create(dto.deadline), dto.logo, dto.industry_id, dto.review_avg_cache,
                dto.title, dto.label_id, dto.is_saved, dto.company_name, dto.cons, dto.pros, dto.salary_lowest,
                dto.salary_highest)
        }
    }
}