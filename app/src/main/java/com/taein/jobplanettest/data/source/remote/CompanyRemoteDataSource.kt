package com.taein.jobplanettest.data.source.remote

import android.util.Log
import androidx.annotation.VisibleForTesting
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.data.entity.Theme
import com.taein.jobplanettest.data.source.repository.CompanyDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Function
import java.util.ArrayList


class CompanyRemoteDataSource(val companyService : CompanyService) :
    CompanyDataSource {

    companion object {
        private var INSTANCE: CompanyRemoteDataSource? = null
        @JvmStatic
        fun getInstance(companyService : CompanyService): CompanyRemoteDataSource {
            if (INSTANCE == null) {
                synchronized(CompanyRemoteDataSource::javaClass) {
                    INSTANCE = CompanyRemoteDataSource(companyService)
                }
            }
            return INSTANCE!!
        }
        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }

    override fun insertAll(companys: List<CompanyWithThemes>) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flowable<List<CompanyWithThemes>> {
        return companyService.getAll()
            .map { it.companyDtos }
            .flatMap { Flowable.fromIterable(it) }
            .map{ CompanyWithThemes.create(it) }
            .toList()
            .toFlowable()
    }

    override fun get(id: Int): Company {
        TODO("Not yet implemented")
    }
}