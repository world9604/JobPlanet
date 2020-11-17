package com.taein.jobplanettest.util

import android.util.Log
import io.reactivex.functions.Consumer

class ErrorHandler private constructor() : Consumer<Throwable?> {
    val COMPANY_ERROR_HANDLER = "COMPANY_ERROR_HANDLER"

    override fun accept(throwable: Throwable?) {
        Log.e(COMPANY_ERROR_HANDLER,"Error on " + Thread.currentThread().name + ":", throwable)
    }

    companion object {
        private val INSTANCE = ErrorHandler()

        fun get(): ErrorHandler {
            return INSTANCE
        }
    }
}