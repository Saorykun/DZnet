package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tema2 extends AppCompatActivity {
    final private String Module = "2";

    @Override
    protected void onPause() {
        super.onPause();
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.DelNum(Module);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if (globalVariable.isBlind()) {
            setTheme(R.style.Theme_MyApplicationBlind);
        } else setTheme(R.style.Theme_MyApplication);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema2);

        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        int otv1;

        //#1
        int i, y;
        i = Generation.RandomInt(1, 9);
        y = Generation.RandomInt(1, 9);
        n1.setText("Найди " + i * 10 + "% от " + (y * 10));
        otv1 = i * y;
        bn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on1);
                if ((String.valueOf(otv1).equals(on1.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check1.setVisibility(View.VISIBLE);
                } else {
                    check1.setImageResource(R.drawable.red);
                    check1.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn1.setEnabled(false);
            }
        });

        //№2
        TextView n2 = findViewById(R.id.n2);
        Button bn2 = findViewById(R.id.bn2);
        EditText on2 = findViewById(R.id.on2);
        ImageView check2 = findViewById(R.id.check2);
        int otv2;

        i = Generation.RandomInt(1, 9);
        y = Generation.RandomInt(1, 9);
        n2.setText("Найди " + i + "% от " + (y * 100));
        otv2 = i * y;
        bn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on2);
                if ((String.valueOf(otv2).equals(on2.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check2.setVisibility(View.VISIBLE);
                } else {
                    check2.setImageResource(R.drawable.red);
                    check2.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn2.setEnabled(false);
            }
        });


        //№3
        TextView n3 = findViewById(R.id.n3);
        Button bn3 = findViewById(R.id.bn3);
        EditText on3 = findViewById(R.id.on3);
        ImageView check3 = findViewById(R.id.check3);
        double otv3;

        i = Generation.RandomInt(1, 9);
        y = Generation.RandomInt(1, 9);
        n3.setText("Найди " + i * 10 + "% от " + (y));
        otv3 = Double.valueOf(y * i) / 10;
        bn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on3);
                if ((String.valueOf(otv3).equals(on3.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check3.setVisibility(View.VISIBLE);
                } else {
                    check3.setImageResource(R.drawable.red);
                    check3.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn3.setEnabled(false);
            }
        });

        //№4
        TextView n4 = findViewById(R.id.n4);
        Button bn4 = findViewById(R.id.bn4);
        EditText on4 = findViewById(R.id.on4);
        ImageView check4 = findViewById(R.id.check4);
        double otv4;

        i = Generation.RandomInt(1, 9);
        y = Generation.RandomInt(1, 9);
        n4.setText("Найди " + i + "% от " + (y));
        otv4 = Double.valueOf(y * i) / 100;
        bn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on4);
                if ((String.valueOf(otv4).equals(on4.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check4.setVisibility(View.VISIBLE);
                } else {
                    check4.setImageResource(R.drawable.red);
                    check4.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn4.setEnabled(false);
            }
        });

        //№5
        TextView n5 = findViewById(R.id.n5);
        Button bn5 = findViewById(R.id.bn5);
        EditText on5 = findViewById(R.id.on5);
        ImageView check5 = findViewById(R.id.check5);
        int otv5;

        i = Generation.RandomMul(100);
        y = Generation.RandomInt(1, i);
        n5.setText("Сколько % совставляет " + y + " от " + i);
        otv5 = y * 100 / i;
        bn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on5);
                if ((String.valueOf(otv5).equals(on5.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check5.setVisibility(View.VISIBLE);
                } else {
                    check5.setImageResource(R.drawable.red);
                    check5.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn5.setEnabled(false);
            }
        });

        //№6
        TextView n6 = findViewById(R.id.n6);
        Button bn6 = findViewById(R.id.bn6);
        EditText on6 = findViewById(R.id.on6);
        ImageView check6 = findViewById(R.id.check6);
        double otv6;

        i = Generation.RandomMul(100);
        y = Generation.RandomInt(i, i + 20);
        n6.setText("Сколько % совставляет " + y + " от " + i);
        otv6 = y * 100 / i;
        bn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on6);
                //  if ((String.valueOf(otv8).equals(on8.getText().toString()))) {
                try {
                    if (otv6 == Double.parseDouble(on6.getText().toString())) {
                        globalVariable.NumTruePlus(Module);
                        check6.setVisibility(View.VISIBLE);
                    } else {
                        //check8.setImageResource(R.drawable.red);
                        // check8.setVisibility(View.VISIBLE);
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check6.setImageResource(R.drawable.red);
                    check6.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn6.setEnabled(false);
            }
        });

        //№7
        TextView n7 = findViewById(R.id.n7);
        Button bn7 = findViewById(R.id.bn7);
        EditText on7 = findViewById(R.id.on7);
        ImageView check7 = findViewById(R.id.check7);
        int otv7;

        i = Generation.RandomMul(100);
        y = Generation.RandomInt(1, 30);
        n7.setText("Найди 100%, если " + i + "% равно " + y);
        otv7 = y * 100 / i;
        bn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on7);
                if ((String.valueOf(otv7).equals(on7.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    check7.setVisibility(View.VISIBLE);
                } else {
                    check7.setImageResource(R.drawable.red);
                    check7.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn7.setEnabled(false);
            }
        });

        //№8
        TextView n8 = findViewById(R.id.n8);
        Button bn8 = findViewById(R.id.bn8);
        EditText on8 = findViewById(R.id.on8);
        ImageView check8 = findViewById(R.id.check8);
        double otv8;

        i = Generation.RandomMul(100);
        int a = Generation.RandomMul(10);
        y = Generation.RandomInt(1, 30);
        n8.setText("Найди 100%, если " + i * a + "% равно " + y);
        otv8 = Double.valueOf(y * 100) / (i * a);
        bn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on8);
                //  if ((String.valueOf(otv8).equals(on8.getText().toString()))) {
                try {
                    if (otv8 == Double.parseDouble(on8.getText().toString())) {
                        globalVariable.NumTruePlus(Module);
                        check8.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check8.setImageResource(R.drawable.red);
                    check8.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn8.setEnabled(false);
            }
        });
    }

    private void Check(GlobalClass globalVariable) {
        Intent i = new Intent(this, test.class);
        globalVariable.NumPlus(Module);
        if (globalVariable.GetNum(Module) == 8) {
            switch (globalVariable.GetNumTrue(Module)) {
                case (0):
                case (1):
                case (2):
                case (3): {
                    globalVariable.setModule(Module, 2);
                    break;
                }
                case (4):
                case (5): {
                    globalVariable.setModule(Module, 3);
                    break;
                }
                case (6): {
                    globalVariable.setModule(Module, 4);
                    break;
                }
                case (7):
                case (8): {
                    globalVariable.setModule(Module, 5);
                    break;
                }
            }
            globalVariable.DelNum(Module);
            startActivity(i);
            finish();
        }
    }

    private void setLock(EditText context) {
        context.setEnabled(false);
        context.setCursorVisible(false);
    }

    @Override
    public void onBackPressed() {
    }
}