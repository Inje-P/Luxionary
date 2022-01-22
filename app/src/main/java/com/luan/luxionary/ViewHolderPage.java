package com.luan.luxionary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPage extends RecyclerView.ViewHolder {

    private ImageView imgTitle;
    private TextView tvTitle1, tvTitle2;

    DataPage data;

    ViewHolderPage(View itemView) {
        super(itemView);
        imgTitle = itemView.findViewById(R.id.imgTitle);
        tvTitle1 = itemView.findViewById(R.id.tvTitle1);
        tvTitle2 = itemView.findViewById(R.id.tvTitle2);
    }

    public void onBind(DataPage data) {
        this.data = data;
        imgTitle.setImageResource(this.data.getImage());
        tvTitle1.setText(this.data.getTitle1());
        tvTitle2.setText(this.data.getTitle2());
    }

}
