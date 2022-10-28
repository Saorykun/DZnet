package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class tema3 extends AppCompatActivity {
    final private String Module = "3";

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
        setContentView(R.layout.activity_tema3);

        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        double otv1;

        //#1
        int i, y, n;
        i = Generation.RandomInt(20, 30);
        y = Generation.RandomInt(5, 9);
        n = Generation.RandomInt(11, 17);
        n1.setText("Найти диаметр шины:\n" + i * 10 + "/" + (y * 10) + " R" + n);
        otv1 = 2 * i * y + n * 25.4d;
        bn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on1);
                try {
                    if (Math.abs(otv1 - Double.parseDouble(on1.getText().toString())) < 0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check1.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check1.setImageResource(R.drawable.red);
                    check1.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn1.setEnabled(false);
            }
        });

        //#2
        TextView n2 = findViewById(R.id.n2);
        Button bn2 = findViewById(R.id.bn2);
        EditText on2 = findViewById(R.id.on2);
        ImageView check2 = findViewById(R.id.check2);
        double otv2;

        i = Generation.RandomInt(20, 30);
        y = Generation.RandomInt(5, 9);
        n = Generation.RandomInt(11, 17);
        n2.setText("Найти диаметр шины:\n" + i * 10 + "/" + (y * 10) + " R" + n);
        otv2 = 2 * i * y + n * 25.4d;
        bn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on2);
                try {
                    if (otv2 - Double.parseDouble(on2.getText().toString()) < 0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check2.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check2.setImageResource(R.drawable.red);
                    check2.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn2.setEnabled(false);
            }
        });

        //#3
        TextView n3 = findViewById(R.id.n3);
        Button bn3 = findViewById(R.id.bn3);
        EditText on3 = findViewById(R.id.on3);
        ImageView check3 = findViewById(R.id.check3);
        double otv3;
        int i2, y2, nc;
        i = Generation.RandomInt(20, 30);
        y = Generation.RandomInt(5, 9);
        n = Generation.RandomInt(11, 17);
        i2 = Generation.RandomInt(20, 30);
        y2 = Generation.RandomInt(5, 9);
        nc = Generation.RandomInt(11, 17);
        n3.setText("На сколько миллиметров изменится диаметр колеса, если заменить колёса\n" + i * 10 + "/" + (y * 10) + " R" + n + "\nколёсами с шинами маркировки\n" + i2 * 10 + "/" + (y2 * 10) + " R" + nc);
        otv3 = Math.abs((2 * i * y - 2 * i2 * y2) + (n - nc) * 25.4d);
        bn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on3);
                try {
                    if (Math.abs(otv3 - Double.parseDouble(on3.getText().toString())) < 0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check3.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check3.setImageResource(R.drawable.red);
                    check3.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn3.setEnabled(false);
            }
        });

        //#4
        TextView n4 = findViewById(R.id.n4);
        Button bn4 = findViewById(R.id.bn4);
        EditText on4 = findViewById(R.id.on4);
        ImageView check4 = findViewById(R.id.check4);
        double otv4;
        i = Generation.RandomInt(20, 30);
        y = Generation.RandomInt(5, 9);
        n = Generation.RandomInt(11, 17);
        i2 = Generation.RandomInt(20, 30);
        y2 = Generation.RandomInt(5, 9);
        nc = Generation.RandomInt(11, 17);
        n4.setText("На сколько миллиметров изменится диаметр колеса, если заменить колёса\n" + i * 10 + "/" + (y * 10) + " R" + n + "\nколёсами с шинами маркировки\n" + i2 * 10 + "/" + (y2 * 10) + " R" + nc);
        otv4 = Math.abs((2 * i * y - 2 * i2 * y2) + (n - nc) * 25.4d);
        bn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on4);
                try {
                    if (Math.abs(otv4 - Double.parseDouble(on4.getText().toString())) < 0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check4.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
                    check4.setImageResource(R.drawable.red);
                    check4.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn4.setEnabled(false);
            }
        });
    }

    private void Check(GlobalClass globalVariable) {
        Intent i = new Intent(this, test.class);
        globalVariable.NumPlus(Module);
        if (globalVariable.GetNum(Module) == 4) {
            switch (globalVariable.GetNumTrue(Module)) {
                case (0):
                case (1): {
                    globalVariable.setModule(Module, 2);
                    break;
                }
                case (2): {
                    globalVariable.setModule(Module, 3);
                    break;
                }
                case (3): {
                    globalVariable.setModule(Module, 4);
                    break;
                }
                case (4): {
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