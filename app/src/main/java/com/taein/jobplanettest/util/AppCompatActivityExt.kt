package com.taein.jobplanettest.util


import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taein.jobplanettest.R


/*fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProviders.of(this, ViewModelFactory.getInstance(application)).get(viewModelClass)*/

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProvider(viewModelStore, ViewModelFactory.getInstance(application)).get(viewModelClass)

fun AppCompatActivity.showShortToast(context: Context, @StringRes resId: Int) {
    Toast.makeText(context, getString(resId), Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showLongToast(context: Context, @StringRes resId: Int) {
    Toast.makeText(context, getString(resId), Toast.LENGTH_LONG).show()
}