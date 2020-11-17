package com.taein.jobplanettest.companyList.viewholder.horizontalTheme

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taein.jobplanettest.companyList.CellTypeItemUserActionListener
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.companyList.CompanyListViewModel
import com.taein.jobplanettest.data.entity.Theme
import com.taein.jobplanettest.databinding.ItemHorizontalThemeBinding

class HorizontalThemeAdapter (val viewModel: CompanyListViewModel, var items : List<Theme>)
    : RecyclerView.Adapter<HorizontalItemViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalItemViewHolder {
        val binding: ItemHorizontalThemeBinding = ItemHorizontalThemeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HorizontalItemViewHolder(viewModel, binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HorizontalItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItem(themes : List<Theme>) {
        Log.d("Company", "setItem Themes")
        items = themes
        notifyDataSetChanged()
    }
}

class HorizontalItemViewHolder(val viewModel: CompanyListViewModel,
                               val binding: ItemHorizontalThemeBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(theme : Theme) {
        binding.theme = theme
        binding.listener = userActionListener
    }

    val userActionListener = object: CellTypeItemUserActionListener {
        override fun onCellTypeItemClicked(themeId: Int) {
            viewModel.openCellTypeItem(themeId, CompanyCellType.CELL_TYPE_HORIZONTAL_THEME)
        }
    }
}