package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.File;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if(globalVariable.isBlind()) {
            setTheme(R.style.Theme_MyApplicationBlind);
        }
        else setTheme(R.style.Theme_MyApplication);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        CheckBox checkBoxForBlind = findViewById(R.id.checkBoxForBlind);
        CheckBox infinityAttempt = findViewById(R.id.infinity_attempt);

        checkBoxForBlind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkBoxForBlind.isChecked()){
                    recreate();
                }
                else{
                    recreate();
                }
                globalVariable.setBlind(checkBoxForBlind.isChecked());
            }
        });
        infinityAttempt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(infinityAttempt.isChecked()){
                    recreate();
                }
                else{
                    recreate();
                }
                globalVariable.setModeAttempt(!infinityAttempt.isChecked());
            }
        });

        infinityAttempt.setChecked(!globalVariable.getModeAttempt());
        checkBoxForBlind.setChecked(globalVariable.isBlind());

        Intent a = new Intent(this, test.class);
        Button setting = findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                globalVariable.setAttempt(1,-100);
                globalVariable.setAttempt(2,-100);
                globalVariable.setAttempt(3,-100);
                globalVariable.setAttempt(4,-100);
                globalVariable.setAttempt(5,-100);
                globalVariable.setAttempt(6,-100);
                globalVariable.setAttempt(7,-100);
                globalVariable.setAttempt(8,-100);
                globalVariable.setAttempt(9,-100);
                globalVariable.setAttempt(10,-100);
                startActivity(a);
                finish();
            }
        });

        Button enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        Button DelData = findViewById(R.id.DelData);
        DelData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    File dir = getApplicationContext().getCacheDir();
                    deleteDir(dir);
                } catch (Exception e) { e.printStackTrace();}
            }
        });
        Button DelDataALL = findViewById(R.id.DelDataALL);
        DelDataALL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                MyDialogFragment myDialogFragment = new MyDialogFragment();
                myDialogFragment.show(manager, "myDialog");
            }
        });
    }

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}