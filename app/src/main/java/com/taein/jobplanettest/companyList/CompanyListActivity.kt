package com.taein.jobplanettest.companyList

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.stetho.Stetho
import com.taein.jobplanettest.R
import com.taein.jobplanettest.companyDetail.*
import com.taein.jobplanettest.databinding.ActivityCompanyListBinding
import com.taein.jobplanettest.util.obtainViewModel
import com.taein.jobplanettest.util.showShortToast
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_company_list.*

class CompanyListActivity : AppCompatActivity(), CellTypeItemNavigator {

    private lateinit var viewModel: CompanyListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = setUpViewModel()
        setBinding(viewModel)
        setRecyclerview(viewModel)
    }

    private fun setUpViewModel(): CompanyListViewModel {
        return obtainViewModel().apply {
            openCellTypeItemEvent.observe(this@CompanyListActivity, openDetailsAsCellType)
        }
    }

    private val openDetailsAsCellType: Observer<Pair<Int, CompanyCellType>> =
        Observer { companyIdAndCellType ->
            val companyId = companyIdAndCellType.first
            val cellType = companyIdAndCellType.second
            when (cellType) {
                CompanyCellType.CELL_TYPE_COMPANY -> { openCompanyDetails(companyId) }
                CompanyCellType.CELL_TYPE_INTERVIEW -> { openInterviewDetails(companyId) }
                CompanyCellType.CELL_TYPE_JOB_POSTING -> { openJobPostingDetails(companyId) }
                CompanyCellType.CELL_TYPE_HORIZONTAL_THEME -> { openJobSearchEventDetails(companyId) }
                CompanyCellType.CELL_TYPE_REVIEW -> { openReviewDetails(companyId) }
                CompanyCellType.CELL_TYPE_SALARY -> { openSalaryDetails(companyId) }
                else -> showShortToast(this, R.string.entered_wrong_way_company_list_activity)
            }
        }

    private fun setBinding(viewModel : CompanyListViewModel) {
        val binding: ActivityCompanyListBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_company_list
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun obtainViewModel(): CompanyListViewModel = obtainViewModel(CompanyListViewModel::class.java)

    private fun setRecyclerview(viewModel: CompanyListViewModel) {
        company_list_recycler_view.setHasFixedSize(true)
        company_list_recycler_view.adapter = CompanyListAdapter(viewModel, arrayListOf())
        company_list_recycler_view.layoutManager = LinearLayoutManager(this)
        company_list_recycler_view.addItemDecoration(VerticalDividerDecoration(50))
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    override fun openCompanyDetails(companyId: Int) {
        val intent = Intent(this, ComapnyDetailActivity::class.java).apply {
            putExtra(ComapnyDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }

    override fun openInterviewDetails(companyId: Int) {
        val intent = Intent(this, InterviewDetailActivity::class.java).apply {
            putExtra(InterviewDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }

    override fun openJobPostingDetails(companyId: Int) {
        val intent = Intent(this, JobPostingDetailActivity::class.java).apply {
            putExtra(JobPostingDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }

    override fun openJobSearchEventDetails(companyId: Int) {
        val intent = Intent(this, JobSearchEventDetailActivity::class.java).apply {
            putExtra(JobSearchEventDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }

    override fun openReviewDetails(companyId: Int) {
        val intent = Intent(this, ReviewDetailActivity::class.java).apply {
            putExtra(ReviewDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }

    override fun openSalaryDetails(companyId: Int) {
        val intent = Intent(this, SalaryDetailActivity::class.java).apply {
            putExtra(SalaryDetailActivity.COMPANY_ID, companyId)
        }
        startActivity(intent)
    }
}