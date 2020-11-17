package com.taein.jobplanettest.companyList.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.taein.jobplanettest.companyList.CellTypeItemUserActionListener
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.companyList.CompanyListViewModel
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.databinding.ItemHorizontalThemeBinding
import com.taein.jobplanettest.databinding.ItemJobPostingBinding

class JobPostingViewHolder(val itemBinding : ItemJobPostingBinding, val viewModel: CompanyListViewModel)
    : CompanyListBaseViewHolder(itemBinding) {

    override fun bind(companyWithThemes: CompanyWithThemes) {
        itemBinding.company = companyWithThemes.company
        itemBinding.listener = userActionListener
    }

    val userActionListener = object: CellTypeItemUserActionListener {
        override fun onCellTypeItemClicked(companyId: Int) {
            viewModel.openCellTypeItem(companyId, CompanyCellType.CELL_TYPE_JOB_POSTING)
        }
    }
}