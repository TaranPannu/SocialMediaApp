package com.example.fall_2022;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsersFragment<adapterUsers> extends Fragment  {
    private ArrayList<example_item> list;
    private ExampleAdapter mExampleAdapter;
    String city="";
    private RecyclerView mRecyclerView;
RecyclerView recyclerView;
    AdapterUsers adapterUsers;
    ArrayList<ModelUser> userList;
    ArrayList<String> v;
    String  UID="";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsersFragment newInstance(String param1, String param2) {
        UsersFragment fragment = new UsersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_users, container, false);
//init recyclerview
                //recyclerView = recyclerView.findViewById(R);
//set it's properties
       // recyclerView. setHasFixedSize (true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //userList=new ArrayList<>();
      mRecyclerView=view.findViewById(R.id.users_recyclerView);
       mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list=new ArrayList<>();
//list.add(new example_item("jj","kkk","gds","jj","kkk","gds","jj","kkk"));
      //  list.add(new example_item("jjj","k,n kk","gnm ds","jjbkj","kk,k","gdjks","jfdj","kkmk"));
     //
   //     list.add(new example_item("jjj","k,n kk","gnm ds","jjbkj","kk,k","gdjks","jfdj","kkmk"));
        getAllUsers();

  //mExampleAdapter = new ExampleAdapter(getActivity(), list);
    //    mRecyclerView.setAdapter(mExampleAdapter);
    //    mExampleAdapter.setOnItemClickListener( DateWise.this);
//getAllUsers();
        return view;
    }


    private void getAllUsers(){
//get current us
        FirebaseUser fUser = FirebaseAuth. getInstance().getCurrentUser();

//get path of database named "Users" containing users info
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference( "Users");
//get all data from path
       ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            //userList.clear();
               for (DataSnapshot ds: snapshot.getChildren()) {
           String name = "" + ds.child("name").getValue();
                String  email = ""+ds.child("email").getValue();
                   String  image = ""+ds.child("image").getValue();
                  UID = ""+ds.child("uid").getValue();

//ModelUser Euser=ds.getValue(ModelUser.class);
                   // ModelUser m=ds.getValue(ModelUser.class);
                 //ModelUser xx=new ModelUser(name,"cc","cc","cc","jj","gg");
                //   userList.add(xx);
//v.add("Fff");
list.add(new example_item(image,name,email,UID));
            }
                mExampleAdapter = new ExampleAdapter(getActivity(), list);
                mRecyclerView.setAdapter(mExampleAdapter);
               // mExampleAdapter.setOnItemClickListener(UsersFragment.this);

            }

        //   mExampleAdapter = new ExampleAdapter(DateWise.this, list);
//
         //  adapterUsers = new AdapterUsers(UsersFragment.this,userList);
                    //set adapter to recycler view
             //     recyclerView.setAdapter(adapterUsers) ;

                            //mExampleAdapter.setOnItemClickListener( UsersFragment.this);

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
           /* @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();
                for (DataSnapshot ds: snapshot.getChildren()) {
                    ModelUser modelUser = ds.getValue (ModelUser.class) ;
//get all users except currently signed in user
               if (!modelUser.getUid().equals(fUser.getUid()))
                     userList.add(modelUser) ;


                     //adapter
                  // adapterUsers = new AdapterUsers(getActivity(), userList);
                    //set adapter to recycler view
               //  recyclerView.setAdapter (adapterUsers) ;
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
               // Toast.makeText(this, "jj", Toast.LENGTH_SHORT).show();
                //
                }
      */ });



        }

  //  public void onItemClick(int position) {

     //   example_item clickedItem = list.get(position);
    //    Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
//Intent intent=new Intent(getActivity(), ChatActivity.class);
//intent.putExtra("hisUid",UID);
//context.startActivity(intent);
        //  Toast.makeText(UsersFragment.this, clickedItem.getTv(), Toast.LENGTH_SHORT).show();
     //   Intent intent = new Intent(UsersFragment.this, ProfileFragment.class);

  //  }

}