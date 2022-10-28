package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class tema9 extends AppCompatActivity {
    final private String Module = "9";
    public enum food {
        маком,
        грибами,
        яблоками,
        сливами,
        вишней
    }
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
        setContentView(R.layout.activity_tema9);

            int k,b,y;

        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        double otv1;

        //#1
        int p, i, r, x;
        i = Generation.RandomInt(2, 8);
        r = Generation.RandomInt(2, 8);
        p=i*i*r;

        n1.setText("Мощность постоянного тока (в ваттах) вычисляется по формуле " +
                        "P=I"+ "\u00B2"+"R, где I— сила тока (в амперах), R — сопротивление (в омах). " +
                        "Пользуясь этой формулой, найдите R (в омах), если P="+p+"Вт и I="+i+"А.");
        otv1 = r;
        bn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on1);
                try {
                    if (Math.abs(otv1 - Double.parseDouble(on1.getText().toString()))<0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check1.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
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

        i = Generation.RandomInt(2, 8);
        r = Generation.RandomInt(2, 8);
        p=i*i*r;

        n2.setText("Мощность постоянного тока (в ваттах) вычисляется по формуле " +
                "P=I"+ "\u00B2"+"R, где I— сила тока (в амперах), R — сопротивление (в омах). " +
                "Пользуясь этой формулой, найдите R (в омах), если P="+p+"Вт и I="+i+"А.");
        otv2 = r;
        bn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on2);
                try {
                    if (Math.abs(otv2 - Double.parseDouble(on2.getText().toString()))<0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check2.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
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

        i = Generation.RandomInt(2, 8);
        r = Generation.RandomInt(2, 8);
        p=i*r;

        n3.setText("Второй закон Ньютона можно записать в виде F = ma , где F— сила (в ньютонах), " +
                "действующая на тело, m— его масса (в килограммах), a— ускорение, с которым движется тело " +
                "(в м/с\u00B2 ). Найдите m (в килограммах), если F = "+p+"Н и a = "+r+"м/с\u00B2.");
        otv3 = i;
        bn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on3);
                try {
                    if (Math.abs(otv3 - Double.parseDouble(on3.getText().toString()))<0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check3.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
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

        i = Generation.RandomInt(2, 8);
        r = Generation.RandomInt(2, 8);
        p=i*r;

        n4.setText("Второй закон Ньютона можно записать в виде F = ma , где F— сила (в ньютонах), " +
                "действующая на тело, m— его масса (в килограммах), a— ускорение, с которым движется тело " +
                "(в м/с\u00B2 ). Найдите m (в килограммах), если F = "+p+"Н и a = "+r+"м/с\u00B2.");
        otv4 = i;
        bn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on4);
                try {
                    if (Math.abs(otv4 - Double.parseDouble(on4.getText().toString()))<0.001d) {
                        globalVariable.NumTruePlus(Module);
                        check4.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
                    check4.setImageResource(R.drawable.red);
                    check4.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn4.setEnabled(false);
            }
        });

        //#5
        TextView n5 = findViewById(R.id.n5);
        Button bn5 = findViewById(R.id.bn5);
        EditText on5 = findViewById(R.id.on5);
        ImageView check5 = findViewById(R.id.check5);
        double otv5;

        k = Generation.RandomInt(2, 8);
        b = Generation.RandomInt(2, 8);
        x = Generation.RandomInt(2, 8);
        n5.setText("Площадь поверхности прямоугольного параллелепипеда с рёбрами " +
                        "a,b и c  вычисляется по формуле S=2(ab + ac + bc). Найдите площадь " +
                        "поверхности прямоугольного параллелепипеда с рёбрами "+k+", "+b+" и "+x+".");
        otv5 = 2*(k*b+b*x+k*x);
        bn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on5);
                try {
                    if (Math.abs(otv5 - Double.parseDouble(on5.getText().toString()))<0.00001d) {
                        globalVariable.NumTruePlus(Module);
                        check5.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
                    check5.setImageResource(R.drawable.red);
                    check5.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn5.setEnabled(false);
            }
        });

        //#6
        TextView n6 = findViewById(R.id.n6);
        Button bn6 = findViewById(R.id.bn6);
        EditText on6 = findViewById(R.id.on6);
        ImageView check6 = findViewById(R.id.check6);
        double otv6;

        k = Generation.RandomInt(2, 8);
        b = Generation.RandomInt(2, 8);
        x = Generation.RandomInt(2, 8);
        n6.setText("Площадь поверхности прямоугольного параллелепипеда с рёбрами " +
                "a,b и c  вычисляется по формуле S=2(ab + ac + bc). Найдите площадь " +
                "поверхности прямоугольного параллелепипеда с рёбрами "+k+", "+b+" и "+x+".");
        otv6 = 2*(k*b+b*x+k*x);
        bn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on6);
                try {
                    if (Math.abs(otv6 - Double.parseDouble(on6.getText().toString()))<0.00001d) {
                        globalVariable.NumTruePlus(Module);
                        check6.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                }
                catch (Exception ex) {
                    check6.setImageResource(R.drawable.red);
                    check6.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                bn6.setEnabled(false);
            }
        });
    }

    private void Check(GlobalClass globalVariable) {
        Intent i = new Intent(this, test.class);
        globalVariable.NumPlus(Module);
        if (globalVariable.GetNum(Module) == 6) {
            switch (globalVariable.GetNumTrue(Module)) {
                case (0):
                case (1):
                case (2): {
                    globalVariable.setModule(Module, 2);
                    break;
                }
                case (3):
                case (4): {
                    globalVariable.setModule(Module, 3);
                    break;
                }
                case (5): {
                    globalVariable.setModule(Module, 4);
                    break;
                }
                case (6): {
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
