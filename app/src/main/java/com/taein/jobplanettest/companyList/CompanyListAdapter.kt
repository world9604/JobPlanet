package com.taein.jobplanettest.companyList

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taein.jobplanettest.companyList.viewholder.CompanyListBaseViewHolder
import com.taein.jobplanettest.companyList.viewholder.factory.CompanyListViewHolderFactory
import com.taein.jobplanettest.data.entity.CompanyWithThemes

class CompanyListAdapter(val viewModel: CompanyListViewModel, var items : List<CompanyWithThemes>)
    : RecyclerView.Adapter<CompanyListBaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyListBaseViewHolder {
        val companyCellType = CompanyCellType.convertIntFrom(viewType)
        return CompanyListViewHolderFactory.create(viewModel, parent, companyCellType)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CompanyListBaseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        var viewType : Int = CompanyCellType.None.viewType
        items[position].company?.let {
            it.cell_type?.let {
                viewType = it.viewType
            }
        }
        return viewType
    }

    fun setItem(companys : List<CompanyWithThemes>) {
        items = companys
        notifyDataSetChanged()
    }
}

class VerticalDividerDecoration(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect : Rect, view : View, parent :RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let {
            outRect.bottom = divHeight;
        }
    }
}

class HorizontalDividerDecoration(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect : Rect, view : View, parent :RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        parent.adapter?.let {
            outRect.right = divHeight;
        }
    }
}