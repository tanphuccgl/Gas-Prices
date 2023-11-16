package com.levi.gasprice;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.levi.gasprice.ApiService;
import com.levi.gasprice.R;
import com.levi.gasprice.StateAdapter;
import com.levi.gasprice.StateData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StateAdapter stateAdapter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateAdapter = new StateAdapter();
        recyclerView.setAdapter(stateAdapter);

        // Button Reload
        Button reloadButton = findViewById(R.id.reloadButton);
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gọi lại API khi nút Reload được nhấn
                stateAdapter.setData(new ArrayList<>());
                callApi();
            }
        });

        // Gọi API khi Activity được tạo
        callApi();
    }

    // Hàm gọi API
    private void callApi() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.collectapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Thêm header authorization vào cuộc gọi API
        String authorizationHeader = "apikey 2A7ckWcy1IpXvamONuyuym:7tFzyD3ZBPEOmbhpJQZukw";
        Call<ApiResponse> call = apiService.getAllUsaPrice(authorizationHeader);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    ApiResponse apiResponse = response.body();
                    if (apiResponse != null && apiResponse.isSuccess()) {
                        List<StateData> stateDataList = apiResponse.getResult();
                        stateAdapter.setData(stateDataList);
                    } else {
                        // Handle unsuccessful response or invalid data
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                // Handle failure
                System.out.println("levi1 : " + t.getMessage());
            }
        });
    }
}
