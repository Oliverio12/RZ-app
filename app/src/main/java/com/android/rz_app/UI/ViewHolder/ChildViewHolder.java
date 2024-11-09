package com.android.rz_app.UI.ViewHolder;

import android.view.View;
import android.widget.TextView;
import com.android.rz_app.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildViewHolder extends RecyclerView.ViewHolder {
    public TextView txvItemRow;
    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);
        txvItemRow = itemView.findViewById(R.id.txvItemRow);
    }


}
