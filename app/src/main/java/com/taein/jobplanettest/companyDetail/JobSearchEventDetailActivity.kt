package com.taein.jobplanettest.companyDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.taein.jobplanettest.R
import com.taein.jobplanettest.databinding.ActivityCompanyListBinding
import com.taein.jobplanettest.databinding.ActivityJobSearchEventDetailBinding

class JobSearchEventDetailActivity : AppCompatActivity() {

    companion object {
        const val COMPANY_ID = "COMPANY_ID"
        const val DEFAULT_COMPANY_ID = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val companyId = getIntent().getIntExtra(COMPANY_ID, DEFAULT_COMPANY_ID)
        setBinding(companyId)
    }

    private fun setBinding(companyId: Int) {
        val binding: ActivityJobSearchEventDetailBinding = DataBindingUtil.setContentView (
            this, R.layout.activity_job_search_event_detail
        )
        binding.lifecycleOwner = this
        binding.companyId = companyId
    }
}