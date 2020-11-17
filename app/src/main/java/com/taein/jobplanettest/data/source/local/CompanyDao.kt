package com.taein.jobplanettest.data.source.local

import androidx.room.*
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.CompanyWithThemes
import com.taein.jobplanettest.data.entity.Theme
import io.reactivex.Flowable

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(company : Company)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompanys(companys : List<Company>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertThemes(companys : List<Theme>)

    @Transaction
    @Query("SELECT * FROM company")
    fun getAll() : Flowable<List<CompanyWithThemes>>

    @Delete
    fun delete(company : Company)
}