package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tema4 extends AppCompatActivity {
    final private String Module = "4";

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
        setContentView(R.layout.activity_tema4);


        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        double otv1;

        //#1
        int i, y, n;
        i = Generation.RandomInt(2, 15);
        y = Generation.RandomInt(2, 25);
        int s = Generation.RandomMul(200);
        while (s <= (i + y))
            s = Generation.RandomMul(200);
        n = s - i - y;
        int[] tmp1 = {i, y, n};
        int nf1 = Generation.RandomInt(0, 4);
        int nf2 = Generation.RandomInt(0, 4);
        int nf3 = Generation.RandomInt(0, 4);
        while ((nf1 == nf2) || (nf1 == nf3) || (nf3 == nf2)) {
            nf2 = Generation.RandomInt(0, 4);
            nf3 = Generation.RandomInt(0, 4);
        }
        int[] tmp2 = {nf1, nf2, nf3};
        int qw = Generation.RandomInt(0, 2);
        n1.setText("Бабушка испекла пирожки: " + i + " с " +
                food.values()[nf1].toString() + ", " + y + " с " +
                food.values()[nf2].toString() + " и " + n + " с " +
                food.values()[nf3].toString() +
                ". Какая вероятность случайно выбрать пирожок с " +
                food.values()[tmp2[qw]].toString());
        otv1 = (double) tmp1[qw] / s;
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

        i = Generation.RandomInt(2, 15);
        y = Generation.RandomInt(2, 25);
        s = Generation.RandomMul(200);
        while (s <= (i + y))
            s = Generation.RandomMul(200);
        n = s - i - y;
        tmp1[0] = i;
        tmp1[1] = y;
        tmp1[2] = n;
        nf1 = Generation.RandomInt(0, 4);
        nf2 = Generation.RandomInt(0, 4);
        nf3 = Generation.RandomInt(0, 4);
        while ((nf1 == nf2) || (nf1 == nf3) || (nf3 == nf2)) {
            nf2 = Generation.RandomInt(0, 4);
            nf3 = Generation.RandomInt(0, 4);
        }
        tmp2[0] = nf3;
        tmp2[1] = nf2;
        tmp2[2] = nf3;
        qw = Generation.RandomInt(0, 2);
        n2.setText("Бабушка испекла пирожки: " + i + " с " +
                food.values()[nf1].toString() + ", " + y + " с " +
                food.values()[nf2].toString() + " и " + n + " с " +
                food.values()[nf3].toString() +
                ". Какая вероятность случайно выбрать пирожок с " +
                food.values()[tmp2[qw]].toString());
        otv2 = (double) tmp1[qw] / s;
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

        i = Generation.RandomInt(2, 10);
        n3.setText("При покупке ручки вероятность того, что она окажется бракованной равна: " + (double) i / 100 +
                ", найди вероятность купить исправную ручку");
        otv3 = 1 - (double) i / 100;
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

        i = Generation.RandomInt(2, 10);
        n4.setText("При покупке ручки вероятность того, что она окажется бракованной равна: " + (double) i / 100 +
                ", найди вероятность купить исправную ручку");
        otv4 = 1 - (double) i / 100;
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

        i = Generation.RandomInt(2, 10);
        n5.setText("При покупке ручки вероятность того, что она окажется бракованной равна: " + (double) i / 100 +
                ", найди вероятность купить две исправные ручки");
        otv5 = (1 - (double) i / 100) * (1 - (double) i / 100);
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

        i = Generation.RandomInt(2, 10);
        n6.setText("При покупке ручки вероятность того, что она окажется бракованной равна: " + (double) i / 100 +
                ", найди вероятность купить две исправные ручки");
        otv6 = (1 - (double) i / 100) * (1 - (double) i / 100);
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
