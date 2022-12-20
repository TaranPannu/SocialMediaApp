package com.example.fall_2022;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<example_item> mExampleList;
    private static OnItemClickListener mListener1;


    public interface OnItemClickListener {

        void onItemClick(int position);

        //Intent intent = new Intent(ExampleAdapter.this, DateWise.class);
        // void startActivity(intent);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener1=  listener;
       // Intent intent = new Intent(ExampleAdapter.this, ProfileFragment.class);
  //Toast.makeText(mContext, "xxxxx", Toast.LENGTH_SHORT).show();
    }

    public ExampleAdapter(Context context, ArrayList<example_item> exampleList) {
        mContext = context;
        mExampleList =exampleList;
    }
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener1);

        return (evh);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        example_item currentItem = mExampleList.get(position);
      holder.user.setText(currentItem.getUser());
        holder.email.setText(currentItem.getEmail());
        //holder.image.setImageResource(currentItem.getImage());
        try {
            Picasso.get().load(currentItem.getImage()).into(holder.image);
        }
        catch (Exception e){

        }
holder.itemView.setOnClickListener((v)-> {
    Toast.makeText(mContext, "hello"+currentItem.getUID(), Toast.LENGTH_SHORT).show();
    Intent intent =new Intent(mContext, ChatterActivity.class);
    intent.putExtra("hisUid",currentItem.getUID());
    mContext.startActivity(intent);
});
     /*   String st = currentItem.getTemp();
        int xx=Integer.valueOf(st.charAt(0)+""+st.charAt(1));
        xx=(xx-32);
        st=String.valueOf((xx*5)/9);
        holder.temp.setText(FtoC(currentItem.getTemp())+"°C");
        st = currentItem.getHigh();
        String t=st.substring(0,st.indexOf(" "));
        st=st.substring(st.indexOf(" ")+1,st.length());
        xx=Integer.valueOf(st.substring(0,st.indexOf(".")));
        xx=(xx-32);
        st=String.valueOf((xx*5)/9);
        holder.htemp.setText(t+": "+(st)+"°C");
        st = currentItem.getLow();
        xx=Integer.valueOf(st.substring(0,st.indexOf(".")));
        xx=(xx-32);
        st=String.valueOf((xx*5)/9);


        if(t.equals("FeelsLike"))
            holder.ltemp.setText(" ");
        else
            holder.ltemp.setText("Low "+st+"°C");*/
      //  holder.wind.setText("Wind "+currentItem.getWind());
        //holder.prec.setText("Preci "+currentItem.getPrec());
        //holder.snow.setText("Snow "+currentItem.getSnow());

    }



    @Override
    public int getItemCount() {
        return mExampleList.size();    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView user;
        public TextView email;


        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
             image = (ImageView) itemView.findViewById(R.id.img);
            user = itemView.findViewById(R.id.user);
            email = itemView.findViewById(R.id.email);
           /* ltemp = itemView.findViewById(R.id.Dlow);
            wind = itemView.findViewById(R.id.Dwind);
            prec = itemView.findViewById(R.id.Dpreci);
            snow = itemView.findViewById(R.id.Dsnow);*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener1 != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener1.onItemClick(position);


                        }
                    }
                }
            });
        }
    }
}
