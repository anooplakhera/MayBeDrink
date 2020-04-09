package com.app.maybedrink.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.maybedrink.R;
import com.app.maybedrink.model.HomeItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<HomeItem> dataList;
    private Context context;
    private int height = 0;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, notification;
        public ImageView img;
        public RelativeLayout mainLayout;

        public MyViewHolder(View view) {
            super(view);

            mainLayout = view.findViewById(R.id.mainLayout);
            title = (TextView) view.findViewById(R.id.title);
            notification = (TextView) view.findViewById(R.id.notification);
            img = view.findViewById(R.id.img);

        }
    }


    public HomeAdapter(Context context, List<HomeItem> dataList, int height) {
        this.context = context;
        this.dataList = dataList;
        this.height = height;
        Log.e("HomeAdapter",""+height);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home, parent, false);

        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) itemView.getLayoutParams();

        if(height>0)
            layoutParams.height = height/4;
        else
            layoutParams.height = 275;

        //layoutParams.width = width/2;
        itemView.setLayoutParams(layoutParams);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HomeItem obj = dataList.get(position);
        holder.title.setText(obj.getName());
        holder.notification.setText(""+obj.getNotificationCount());
        holder.img.setImageResource(obj.getImageID());

        if(obj.getId()==5)
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.greenIcon));
        else
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.white));

        if(obj.getNotificationCount()>0)
            holder.notification.setVisibility(View.VISIBLE);
        else
            holder.notification.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}