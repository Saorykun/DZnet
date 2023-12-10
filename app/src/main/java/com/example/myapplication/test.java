package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityTestBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

public class test extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityTestBinding binding;

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;


    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        mDb = mDBHelper.getWritableDatabase();

        mDb.execSQL("CREATE TABLE IF NOT EXISTS TEST_RES (\n" +
                "            id int PRIMARY KEY,\n" +
                "            date DATE,\n" +
                "            task int,\n" +
                "            ver boolean\n" +
                "    );");


        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent a = new Intent(this, Setting.class);
        setSupportActionBar(binding.appBarTest.toolbar);
        binding.appBarTest.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // отвечает за майл
                final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"igor_kulakov_yu@mail.ru"});
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