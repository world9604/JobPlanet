package com.taein.jobplanettest.companyList.viewholder.horizontalTheme

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.taein.jobplanettest.companyList.*
import com.taein.jobplanettest.companyList.viewholder.CompanyListBaseViewHolder
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.databinding.ItemHorizontalThemeLayoutBinding
import java.util.ArrayList

class HorizontalThemeViewHolder(val itemBinding : ItemHorizontalThemeLayoutBinding,
                                val viewModel: CompanyListViewModel)
    : CompanyListBaseViewHolder(itemBinding) {

    init {
        setUpRecyclerView()
    }

    fun setUpRecyclerView() {
        itemBinding.horizontalThemeRecyclerView.setHasFixedSize(true)
        itemBinding.horizontalThemeRecyclerView.adapter =
            HorizontalThemeAdapter(viewModel, ArrayList(0))
        itemBinding.horizontalThemeRecyclerView.addItemDecoration(HorizontalDividerDecoration(50))
    }

    override fun bind(companyWithThemes: CompanyWithThemes) {
        itemBinding.themes = companyWithThemes.themes
    }
}