package com.example.fall_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    //TextView tv;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //ActionBAr and its title
         actionBar=getSupportActionBar();
        actionBar.setTitle("Profile");
        firebaseAuth =firebaseAuth.getInstance();
        BottomNavigationView navigationView=findViewById(R.id.navigation);
        navigationView.setOnItemSelectedListener(selectedListener);
// deafault on start
        actionBar.setTitle ("Start") ; //ch
        HomeFragment fragment1 = new HomeFragment ();
        FragmentTransaction ft1 = getSupportFragmentManager () .beginTransaction();
        ft1.replace(R.id.content, fragment1,  "");
        ft1.commit ();
//tv=findViewById(R.id.Textv);
    }

    public NavigationBarView.OnItemSelectedListener selectedListener =
            new NavigationBarView.OnItemSelectedListener(){

                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//handle item clicks
                    switch (menuItem.getItemId()) {

                        case R.id.nav_home:
//home fragment transaction
                            actionBar.setTitle ("Home") ; //ch
                            HomeFragment fragment1 = new HomeFragment ();
                            FragmentTransaction ft1 = getSupportFragmentManager () .beginTransaction();
                            ft1.replace(R.id.content, fragment1,  "");
                            ft1.commit ();
                            return true;
                        case R.id.nav_profile:
//profile fragment transaction

                            actionBar.setTitle ("Profile") ; //ch
                            ProfileFragment fragment2 = new ProfileFragment ();
                            FragmentTransaction ft2 = getSupportFragmentManager () .beginTransaction();
                            ft2.replace(R.id.content, fragment2,  "");
                            ft2.commit ();
                            return true;
                        case R.id.nav_users:

                            actionBar.setTitle ("Users") ; //ch
                            UsersFragment fragment3 = new UsersFragment ();
                            FragmentTransaction ft3 = getSupportFragmentManager () .beginTransaction();
                            ft3.replace(R.id.content, fragment3,  "");
                            ft3.commit ();
                            return true;
                        case R.id.nav_chat:
                            actionBar.setTitle ("Chat") ; //ch
                            ChatListFragment fragment4 = new ChatListFragment ();
                            FragmentTransaction ft4 = getSupportFragmentManager () .beginTransaction();
                            ft4.replace(R.id.content, fragment4,  "");
                            ft4.commit ();
//users fragment transaction
                            return true;
                    }
                        return false;
                }};
                    private void checkUserStatus(){
        //get Current user
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            //user is signed stay here
            //set email of logged in user
//tv.setText(user.getEmail().toString());
        }else{
            //  user not signed go to main actvivty
            startActivity(new Intent(DashboardActivity.this,MainActivity.class));
            finish();;
        }
    }
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
    protected void onStart() {
// check on start of app
        checkUserStatus();
        super.onStart();

    }



    /*inflate options menu*/

    public boolean onCreateOptionsMenu (Menu menu) {
//inflating menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
       // Toast.makeText(this, "hjjj", Toast.LENGTH_SHORT).show();
        //get item id
        int id=item.getItemId();
if(id==R.id.action_logout){
firebaseAuth.signOut();
checkUserStatus();
}
return super.onOptionsItemSelected(item);
    }
        /*handle menu item clicks*/

}