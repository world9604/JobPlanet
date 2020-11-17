package com.taein.jobplanettest.companyList.viewholder.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.companyList.CompanyListViewModel
import com.taein.jobplanettest.companyList.viewholder.*
import com.taein.jobplanettest.companyList.viewholder.horizontalTheme.HorizontalThemeViewHolder
import com.taein.jobplanettest.databinding.*

class CompanyListViewHolderFactory {

    companion object {
        @JvmStatic
        fun create(viewModel: CompanyListViewModel, parent: ViewGroup,
                   companyCellType: CompanyCellType): CompanyListBaseViewHolder {
            when (companyCellType) {
                CompanyCellType.CELL_TYPE_COMPANY -> {
                    val binding: ItemCompanyBinding = ItemCompanyBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return CompanyViewHolder(binding, viewModel)
                }
                CompanyCellType.CELL_TYPE_HORIZONTAL_THEME -> {
                    val binding: ItemHorizontalThemeLayoutBinding = ItemHorizontalThemeLayoutBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return HorizontalThemeViewHolder(binding, viewModel)
                }
                CompanyCellType.CELL_TYPE_INTERVIEW -> {
                    val binding: ItemInterviewBinding = ItemInterviewBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return InterviewViewHolder(binding, viewModel)
                }
                CompanyCellType.CELL_TYPE_JOB_POSTING -> {
                    val binding: ItemJobPostingBinding = ItemJobPostingBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return JobPostingViewHolder(binding, viewModel)
                }
                CompanyCellType.CELL_TYPE_REVIEW -> {
                    val binding: ItemReviewBinding = ItemReviewBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return ReviewViewHolder(binding, viewModel)
                }
                CompanyCellType.CELL_TYPE_SALARY -> {
                    val binding: ItemSalaryBinding = ItemSalaryBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return SalaryViewHolder(binding, viewModel)
                }
                else -> {
                    val binding: ItemCompanyBinding = ItemCompanyBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                    return CompanyViewHolder(binding, viewModel)
                }
            }
        }
    }
}