package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    MaterialToolbar toolbar;
    FrameLayout frameLayout;

    NavigationView navigationView;

    BottomNavigationView bottomNavigation;

    View headerView;

    TextView headerTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottomNavigation = findViewById(R.id.bottomNavigation);

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);

        headerView= navigationView.getHeaderView(0);
        headerTitle=headerView.findViewById(R.id.headerTitle);

        bottomNavigation.getOrCreateBadge(R.id.home).setNumber(5);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,drawerLayout,toolbar,R.string.drawer_close,R.string.drawer_open
        );
        drawerLayout.addDrawerListener(toggle);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.icon_homes) {
                    FragmentManager fragmentManager =getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frameLayout, new FirstFragment());
                    fragmentTransaction.commit();

                    //headerTitle.setText("Tapu");
                    //Toast.makeText(MainActivity.this, "icon_homes", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                }else if (itemId == R.id.profiles) {
                    Toast.makeText(MainActivity.this, "profiles", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (itemId == R.id.setting) {
                    Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else if (itemId == R.id.likes) {
                    Toast.makeText(MainActivity.this, "likes", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });




//



        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.share){
                    Toast.makeText(MainActivity.this, "tool share", Toast.LENGTH_SHORT).show();
                }else if (item.getItemId()==R.id.like){
                    Toast.makeText(MainActivity.this, "tool like", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });





        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                if (item.getItemId()==R.id.home){

                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId()==R.id.notification) {

                    Toast.makeText(MainActivity.this, "notification", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.profile) {
                    Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();

                }

                return true;
            }
        });



    }
}