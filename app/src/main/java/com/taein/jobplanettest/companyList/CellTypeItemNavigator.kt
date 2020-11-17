package com.taein.jobplanettest.companyList

interface CellTypeItemNavigator {

    fun openCompanyDetails(companyId: Int)
    fun openInterviewDetails(companyId: Int)
    fun openJobPostingDetails(companyId: Int)
    fun openJobSearchEventDetails(companyId: Int)
    fun openReviewDetails(companyId: Int)
    fun openSalaryDetails(companyId: Int)
}