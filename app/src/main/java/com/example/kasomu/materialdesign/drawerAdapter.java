package com.example.kasomu.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by kasomu on 8/19/2015.
 */
public class drawerAdapter extends RecyclerView.Adapter<drawerAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater inflater;
    List<drawer_recycleViewInfo> data = Collections.emptyList();
    public drawerAdapter(Context context,List<drawer_recycleViewInfo> data)
    {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Using Layout Inflater. Get the root element and passing that to myViewHolder
        View view = inflater.inflate(R.layout.drawer_list,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
            drawer_recycleViewInfo current = data.get(position);
            holder.title.setText(current.text);
            holder.image.setImageResource(current.iconid);
            Log.d("drawAdapter", "Position there is : " + position);
           /* holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("OnClick","Clicked the image :"+position);
                    Toast.makeText(context,"Item selected is "+position,Toast.LENGTH_SHORT).show();
                }
            });
            //holder.title.setOnClickListener(();
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("OnClick","Clicked the Text :"+position);
                    Toast.makeText(context,"Item selected Text is "+position,Toast.LENGTH_SHORT).show();
                }
            });*/
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("OnClick","Clicked the Item :"+position+" "+holder.title.getText());
                    Toast.makeText(context,holder.title.getText()+" is selected",Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.drawer_textid);
            image = (ImageView) itemView.findViewById(R.id.drawer_imageiconid);

        }
    }
}
