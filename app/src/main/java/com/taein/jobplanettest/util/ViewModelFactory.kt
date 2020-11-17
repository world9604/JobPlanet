package com.taein.jobplanettest.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taein.jobplanettest.companyList.CompanyListViewModel
import com.taein.jobplanettest.data.source.repository.CompanyRepository
import com.taein.jobplanettest.data.source.local.CompanyDatabase
import com.taein.jobplanettest.data.source.local.CompanyLocalDataSource
import com.taein.jobplanettest.data.source.remote.CompanyRemoteDataSource
import com.taein.jobplanettest.data.source.remote.CompanyRetrofitServiceFactory
import com.taein.jobplanettest.data.source.remote.CompanyService


class ViewModelFactory private constructor(
        private val companyRepository: CompanyRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(CompanyListViewModel::class.java) ->
                        CompanyListViewModel(companyRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(
                            Injection.provideTasksRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }


        @VisibleForTesting fun destroyInstance() {
            INSTANCE = null
        }
    }
}

object Injection {
    fun provideTasksRepository(context: Context): CompanyRepository {
        // Local Data Source
        val database = CompanyDatabase.getInstance(context)
        // Remote Data Source
        val companyService: CompanyService = CompanyRetrofitServiceFactory.create()

        return CompanyRepository.getInstance(
                    CompanyRemoteDataSource.getInstance(companyService),
                    CompanyLocalDataSource.getInstance(database.companyDao()))
    }
}
