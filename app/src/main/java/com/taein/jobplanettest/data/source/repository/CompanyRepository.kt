package com.taein.jobplanettest.data.source.repository

import android.annotation.SuppressLint
import android.util.Log
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import io.reactivex.Flowable

@SuppressLint("CheckResult")
class CompanyRepository(
    val companyRemoteDataSource: CompanyDataSource,
    val companyLocalDataSource: CompanyDataSource
) : CompanyDataSource {

    companion object {
        private var INSTANCE: CompanyRepository? = null
        @JvmStatic
        fun getInstance(companyRemoteDataSource: CompanyDataSource,
                        companyLocalDataSource: CompanyDataSource
        ) =
            INSTANCE
                ?: synchronized(CompanyRepository::class.java) {
                INSTANCE
                    ?: CompanyRepository(
                        companyRemoteDataSource,
                        companyLocalDataSource
                    )
                    .also { INSTANCE = it }
            }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun insertAll(companyWithThemes : List<CompanyWithThemes>) {
        companyLocalDataSource.insertAll(companyWithThemes)
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    //todo - internet 연결이 되지 않으면 local에서 데이터를 읽어 온다.
    override fun getAll(): Flowable<List<CompanyWithThemes>> {
        return companyRemoteDataSource.getAll()
            .doOnNext { insertAll(it) }
            .doOnNext { companyLocalDataSource.getAll() }
    }

    override fun get(id: Int): Company {
        TODO("Not yet implemented")
    }
}
