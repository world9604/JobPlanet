package com.taein.jobplanettest.companyList


import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.data.source.repository.CompanyRepository
import com.taein.jobplanettest.util.ErrorHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


@SuppressLint("CheckResult")
class CompanyListViewModel(private val companyRepository: CompanyRepository) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _companys = MutableLiveData<List<CompanyWithThemes>>()
    val companys: LiveData<List<CompanyWithThemes>>
        get() = _companys

    private val _openCellTypeItemEvent = MutableLiveData<Pair<Int, CompanyCellType>>()
    val openCellTypeItemEvent: LiveData<Pair<Int, CompanyCellType>>
        get() = _openCellTypeItemEvent

    fun onStart() {
        val disposable = companyRepository.getAll()
            .subscribeOn(Schedulers.io())
            .doOnError(ErrorHandler.get())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _companys.value = ArrayList(it)
            }
        compositeDisposable.add(disposable)
    }

    fun openCellTypeItem(companyId: Int, companyCellType: CompanyCellType) {
        _openCellTypeItemEvent.value = Pair(companyId, companyCellType)
    }

    fun onDestroy() {
        onDestroyDisposable()
        onDestroyRepository()
    }

    // Repository 메모리 해제
    private fun onDestroyRepository() {
        CompanyRepository.destroyInstance()
    }

    // RxJava 메모리 해제
    private fun onDestroyDisposable() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
