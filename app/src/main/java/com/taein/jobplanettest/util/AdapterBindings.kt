package com.taein.jobplanettest.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.taein.jobplanettest.R
import com.taein.jobplanettest.companyList.CompanyListAdapter
import com.taein.jobplanettest.companyList.viewholder.horizontalTheme.HorizontalThemeAdapter
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.data.entity.Theme


object AdapterBindings {

    @BindingAdapter("bind:item")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, companys: List<CompanyWithThemes>?) {
        with(recyclerView.adapter as CompanyListAdapter) {
            companys?.let {
                setItem(it)
            }
        }
    }

    @BindingAdapter("bind:themeItem")
    @JvmStatic
    fun bindThemeItem(recyclerView: RecyclerView, themes: List<Theme>?) {
        with(recyclerView.adapter as HorizontalThemeAdapter) {
            themes?.let {
                setItem(it)
            }
        }
    }

    @BindingAdapter("bind:src")
    @JvmStatic
    fun bindSrc(imageView: ImageView, logoPath: String?) {
        if (logoPath == null) {
            Picasso.get().load(R.drawable.ic_launcher_background).into(imageView)
        } else {
            Picasso.get()
                .load(logoPath)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(imageView)
        }
    }

    @BindingAdapter("bind:rate_total_avg")
    @JvmStatic
    fun bindRateTotalAvg(textView: TextView, totalAvg: Double?) {
        totalAvg?.let {
            textView.text = "$it"
        }
    }
}