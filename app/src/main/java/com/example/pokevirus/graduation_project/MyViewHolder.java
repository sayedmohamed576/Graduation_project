package com.example.pokevirus.graduation_project;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by medos on 11/10/2016.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

   TextView DoctorName;
    public MyViewHolder(View itemView) {
        super(itemView);
        DoctorName=(TextView) itemView.findViewById(R.id.txt_docname);
    }
}
