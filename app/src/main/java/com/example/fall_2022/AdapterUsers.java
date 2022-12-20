package com.example.fall_2022;

import android.content.Context;
import android.widget.*;
import android.widget.TextView;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/*public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder>{
    //view holder class
    class MyHolder extends RecyclerView.ViewHolder{

        ImageView mAvatarIv;
        TextView mNameTv, mEmailTv;

        public MyHolder(@NonNull View itemView) {
            super (itemView) ;

//init views

            mAvatarIv = itemView. findViewById(R.id.avatarIv) ;
            mEmailTv=itemView.findViewById(R.id.emailTv);
            mNameTv = itemView.findViewById(R.id.nameTv) ;



        }}
    Context context;
    List<String> userList;

    public AdapterUsers(Context context,List<String> userList){
        this.context=context;
        this.userList=userList;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.row_users,parent);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {
   //     String userImage = userList.get(i).getImage();

        String userName = userList.get(i);//.get(i);//.getName();

        //String userEmail = userList.get(i).getName();//.get(i);//.getEmail();

        holder.mEmailTv.setText("userName");
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


}*/
 public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder> {
    Context context;
    String userList;
    List<ModelUser> v;
//constructor

    public AdapterUsers (Context context, List<ModelUser> v) {
        this.context = context;
        this.v = v;

    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout(user.xml)
        View view=LayoutInflater.from(context).inflate(R.layout.row_users, parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i) {

//gqet data
      String userImage = v.get(i).getImage();

        String userName = v.get(i).getName();//.get(i);//.getName();

        String userEmail = v.get(i).getName();//.get(i);//.getEmail();

//set data
        holder.mNameTv.setText(userName);
        holder.mEmailTv.setText(userEmail);
        try {
         Picasso.get().load(userImage).placeholder(R.drawable.ic_default_img).into(holder.mAvatarIv);

        } catch (Exception e) {


        }
        //handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+userEmail, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return v.size();
    }

    //view holder class
    class MyHolder extends RecyclerView.ViewHolder{

        ImageView mAvatarIv;
        TextView mNameTv, mEmailTv;

        public MyHolder(@NonNull View itemView) {
            super (itemView) ;

//init views

            mAvatarIv = itemView. findViewById(R.id.avatarIv) ;
            mEmailTv=itemView.findViewById(R.id.emailTv);
            mNameTv = itemView.findViewById(R.id.nameTv) ;



        }}}


/*class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    private ArrayList<ModelUser> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
         //   mImageView = itemView.findViewById(R.id.imageView);
         //   mTextView1 = itemView.findViewById(R.id.textView);
        mTextView2 = itemView.findViewById(R.id.nameTv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }}
    public ExampleAdapter(ArrayList<ModelUser> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_users, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        String currentItem = mExampleList.get(position).getEmail();

      //  holder.mImageView.setImageResource(currentItem.getImageResource());
       // holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
*/