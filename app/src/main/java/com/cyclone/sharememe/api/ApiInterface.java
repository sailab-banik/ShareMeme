package com.cyclone.sharememe.api;

import com.cyclone.sharememe.model.MemeResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("gimme")
    Single<MemeResponse> getMemesByPage(@Query("count") int count);
}