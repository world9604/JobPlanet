package com.taein.jobplanettest.data.source.repository

import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import io.reactivex.Flowable

interface CompanyDataSource {

    fun insertAll(companyWithThemes : List<CompanyWithThemes>)

    fun delete(id : Int)

    fun getAll() : Flowable<List<CompanyWithThemes>>

    fun get(id : Int) : Company
}