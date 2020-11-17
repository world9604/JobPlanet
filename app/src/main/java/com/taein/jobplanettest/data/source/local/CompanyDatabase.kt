package com.taein.jobplanettest.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.taein.jobplanettest.companyList.CompanyCellType
import com.taein.jobplanettest.data.entity.Company
import com.taein.jobplanettest.data.entity.Theme


@Database(entities = arrayOf(Company::class, Theme::class), version = 15)
@TypeConverters(CompanyCellType::class)
abstract class CompanyDatabase : RoomDatabase() {

    abstract fun companyDao() : CompanyDao

    companion object {
        private var INSTANCE: CompanyDatabase? = null
        private val lock = Any()
        fun getInstance(context: Context): CompanyDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CompanyDatabase::class.java, "Company.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}