package com.levi.gasprice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {
    private List<StateData> stateDataList;

    public void setData(List<StateData> stateDataList) {
        this.stateDataList = stateDataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_state, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, int position) {
        if (stateDataList != null) {
            StateData stateData = stateDataList.get(position);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String currentDateTime = dateFormat.format(new Date());

            // Set the current date and time to the TextView
            holder.textState.setText("currency: " + stateData.getCurrency());
            holder.textRegular.setText("name: " + stateData.getName());
            holder.textMidGrade.setText("gasoline: " + stateData.getGasoline());
            holder.textPremium.setText("midGrade: " + stateData.getMidGrade());
            holder.textDiesel.setText("premium: " + stateData.getPremium());
            holder.textDateTime.setText("Current Date and Time: " + currentDateTime);
        }
    }

    @Override
    public int getItemCount() {
        return stateDataList != null ? stateDataList.size() : 0;
    }

    public static class StateViewHolder extends RecyclerView.ViewHolder {
        TextView textState, textRegular, textMidGrade, textPremium, textDiesel,textDateTime;

        public StateViewHolder(@NonNull View itemView) {
            super(itemView);
            textState = itemView.findViewById(R.id.textState);
            textRegular = itemView.findViewById(R.id.textRegular);
            textMidGrade = itemView.findViewById(R.id.textMidGrade);
            textPremium = itemView.findViewById(R.id.textPremium);
            textDiesel = itemView.findViewById(R.id.textDiesel);
            textDateTime = itemView.findViewById(R.id.textDateTime);
        }
    }
}
