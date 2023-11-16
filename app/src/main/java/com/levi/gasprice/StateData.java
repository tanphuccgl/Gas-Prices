package com.levi.gasprice;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StateData {
    @SerializedName("currency")
    private String currency;

    @SerializedName("name")
    private String name;

    @SerializedName("gasoline")
    private String gasoline;

    @SerializedName("midGrade")
    private String midGrade;

    @SerializedName("premium")
    private String premium;

    @SerializedName("diesel")
    private String diesel;

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public String getGasoline() {
        return gasoline;
    }

    public String getMidGrade() {
        return midGrade;
    }

    public String getPremium() {
        return premium;
    }

    public String getDiesel() {
        return diesel;
    }
}
