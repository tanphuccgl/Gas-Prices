package com.levi.gasprice;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {
    @GET("gasPrice/allUsaPrice")
    Call<ApiResponse> getAllUsaPrice(@Header("authorization") String authorization);
}
