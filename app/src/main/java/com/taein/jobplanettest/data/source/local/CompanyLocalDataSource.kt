package com.taein.jobplanettest.data.source.local

import android.util.Log
import androidx.annotation.VisibleForTesting
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.data.entity.Theme
import com.taein.jobplanettest.data.source.repository.CompanyDataSource
import io.reactivex.Flowable


class CompanyLocalDataSource (val companayDao: CompanyDao) :
    CompanyDataSource {

    companion object {
        private var INSTANCE: CompanyLocalDataSource? = null
        @JvmStatic
        fun getInstance(companayDao: CompanyDao): CompanyLocalDataSource {
            if (INSTANCE == null) {
                synchronized(CompanyLocalDataSource::javaClass) {
                    INSTANCE = CompanyLocalDataSource(companayDao)
                }
            }
            return INSTANCE!!
        }
        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }

    override fun insertAll(companyWithThemes: List<CompanyWithThemes>) {
        val (companys, themes) = getCompanyAndThemes(companyWithThemes)
        companayDao.insertCompanys(companys)
        companayDao.insertThemes(themes)
    }

    private fun getCompanyAndThemes(companyWithThemes: List<CompanyWithThemes>):
            Pair<ArrayList<Company>, ArrayList<Theme>> {
        var companys = arrayListOf<Company>()
        var themes = arrayListOf<Theme>()
        companyWithThemes.forEach {
            addCompany(it, companys)
            addThemes(it, themes)
        }
        return Pair(companys, themes)
    }

    private fun addCompany(companyWithThemes: CompanyWithThemes, companys: ArrayList<Company>) {
        companyWithThemes.company?.let {
            companys.add(it)
        }
    }

    private fun addThemes(it: CompanyWithThemes, themes: ArrayList<Theme>) {
        it.themes?.let {
            it.forEach {
                themes.add(it)
            }
        }
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flowable<List<CompanyWithThemes>> {
        return companayDao.getAll()
    }

    override fun get(id: Int): Company {
        TODO("Not yet implemented")
    }
}