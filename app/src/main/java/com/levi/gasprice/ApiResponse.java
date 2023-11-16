package com.levi.gasprice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("result")
    private List<StateData> result;

    public boolean isSuccess() {
        return success;
    }

    public List<StateData> getResult() {
        return result;
    }
}
