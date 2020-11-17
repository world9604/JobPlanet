package com.taein.jobplanettest.data.source.remote;

import com.taein.jobplanettest.data.dto.SearchedCompanyDto;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface CompanyService {

    @GET("mobile-config/test_data.json")
    Flowable<SearchedCompanyDto> getAll();
}
