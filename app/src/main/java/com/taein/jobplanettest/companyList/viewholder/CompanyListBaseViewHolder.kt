package com.taein.jobplanettest.companyList.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.databinding.ItemSalaryBinding

abstract class CompanyListBaseViewHolder(val binding: ViewDataBinding)
    : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(companyWithThemes : CompanyWithThemes)
}