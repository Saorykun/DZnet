package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tema10 extends AppCompatActivity {
    final private String Module = "10";

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
        setContentView(R.layout.activity_tema10);

        int k, b, y;

        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        double otv1;

        //#1
        int p, i, r, x;
        r = Generation.RandomInt(8, 12);
        i = Generation.RandomInt(4, 7);
        if ((i % 2 != 0) || (r % 2 != 0)) {
            r = Generation.RandomInt(8, 12);
            i = Generation.RandomInt(4, 7);
        }
        n1.setText(r + " столбов соединены между собой проводами так, что от каждого " +
                "столба отходит ровно " + i + " проводов. Сколько всего проводов протянуто между этими " + r + " столбами?");
        otv1 = r * i / 2;
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

        r = Generation.RandomInt(8, 12);
        i = Generation.RandomInt(4, 7);
        if ((i % 2 != 0) || (r % 2 != 0)) {
            r = Generation.RandomInt(8, 12);
            i = Generation.RandomInt(4, 7);
        }
        n2.setText(r + " столбов соединены между собой проводами так, что от каждого " +
                "столба отходит ровно " + i + " проводов. Сколько всего проводов протянуто между этими " + r + " столбами?");
        otv2 = r * i / 2;
        bn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on2);
                try {
                    if (Math.abs(otv2 - Double.parseDouble(on2.getText().toString())) < 0.001d) {
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

        i = Generation.RandomInt(10, 20);
        r = Generation.RandomInt(10, 20);
        n3.setText("На поверхности глобуса фломастером проведены " + i + " параллелей и " + r + " меридианов. На сколько частей проведённые линии разделили поверхность глобуса?" +
                "Меридиан — это дуга окружности, соединяющая Северный и Южный полюсы. Параллель — это окружность, лежащая в плоскости, параллельной плоскости экватора.");
        otv3 = (i + 1) * r;
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

        i = Generation.RandomInt(10, 20);
        r = Generation.RandomInt(10, 20);
        n4.setText("На поверхности глобуса фломастером проведены " + i + " параллелей и " + r + " меридианов. На сколько частей проведённые линии разделили поверхность глобуса?" +
                "Меридиан — это дуга окружности, соединяющая Северный и Южный полюсы. Параллель — это окружность, лежащая в плоскости, параллельной плоскости экватора.");
        otv4 = (i + 1) * r;
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

        //#5
        TextView n5 = findViewById(R.id.n5);
        Button bn5 = findViewById(R.id.bn5);
        EditText on5 = findViewById(R.id.on5);
        ImageView check5 = findViewById(R.id.check5);
        double otv5;
        int a;

        a = Generation.RandomInt(2, 8);
        b = Generation.RandomInt(10, 20);
        n5.setText("Взяли несколько досок и распилили их. Всего сделали " + a + " поперечных распилов, в итоге получилось " + b + " кусков. Сколько досок взяли?");
        otv5 = b - a;
        bn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on5);
                try {
                    if (Math.abs(otv5 - Double.parseDouble(on5.getText().toString())) < 0.00001d) {
                        globalVariable.NumTruePlus(Module);
                        check5.setVisibility(View.VISIBLE);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception ex) {
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

        a = Generation.RandomInt(2, 8);
        b = Generation.RandomInt(10, 20);
        n6.setText("Взяли несколько досок и распилили их. Всего сделали " + a + " поперечных распилов, в итоге получилось " + b + " кусков. Сколько досок взяли?");
        otv6 = b - a;
        bn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on6);
                try {
                    if (Math.abs(otv6 - Double.parseDouble(on6.getText().toString())) < 0.00001d) {
                        globalVariable.NumTruePlus(Module);
                        check6.setVisibility(View.VISIBLE);
                    } else {
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
