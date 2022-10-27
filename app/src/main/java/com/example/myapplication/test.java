package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityTestBinding;

public class test extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityTestBinding binding;

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent a = new Intent(this, com.example.myapplication.Setting.class);
        setSupportActionBar(binding.appBarTest.toolbar);
        binding.appBarTest.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // отвечает за майл
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SENDTO);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                        new String[] { "igor_kulakov_yu@mail.ru" });
                emailIntent.setData(Uri.parse("mailto:"));
                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        MenuItem getItem = menu.findItem(R.id.action_settings);
        Intent a = new Intent(this, com.example.myapplication.Setting.class);
        if (getItem != null) {
            getItem.setIntent(a);
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}