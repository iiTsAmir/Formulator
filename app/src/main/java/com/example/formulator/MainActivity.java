package com.example.formulator;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replace_fragment(new LoginFragment());

        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout, toolbar,
                R.string.open_drawer,
                R.string.close_drawer);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white_green));

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                /*switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.editing:
                        Toast.makeText(MainActivity.this, "editing", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.subject1:
                        Toast.makeText(MainActivity.this, "subject1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.subject2:
                        Toast.makeText(MainActivity.this, "subject2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.login:
                        Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
                */
                int id = item.getItemId();
                if (id == R.id.home) {
                    replace_fragment(new HomeFragment());
                } else if (id == R.id.managing) {
                    replace_fragment(new ManagingFragment());
                } else if (id == R.id.subject1) {
                    replace_fragment(new SubjectFragment());
                } else if (id == R.id.subject2) {
                    replace_fragment(new SubjectFragment());
                } else if (id == R.id.login) {
                    replace_fragment(new LoginFragment());
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;


            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else super.onBackPressed();
    }

    private void replace_fragment(Fragment input_fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FLayout, input_fragment);
        fragmentTransaction.commit();

    }
}