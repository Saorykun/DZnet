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

public class tema7 extends AppCompatActivity {
    final private int Module = 7;
    public enum name {
        Даша,
        Маша,
        Ира,
        Катя
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
        setContentView(R.layout.activity_tema7);

        int i, y, z;
        //#1
        TextView n1 = findViewById(R.id.n1);
        Button bn1 = findViewById(R.id.bn1);
        EditText on1 = findViewById(R.id.on1);
        ImageView check1 = findViewById(R.id.check1);
        double otv1;

        i = Generation.RandomMul(100);
        y = Math.abs(i+ Generation.RandomMul(100));
        while((i==y)||(i==0)||(y==0)||(i>y)){
            i = Generation.RandomMul(100);
            y = Math.abs(i+ Generation.RandomMul(100));
        }
  //      while (!Generation.CheckZn(y-i)||(i>=y)){
  //          y = Generation.RandomMul(100);
  //      }
        int nf1= Generation.RandomInt(0,3);
        int nf2= Generation.RandomInt(0,3);
        while (nf1==nf2) {
            nf2 = Generation.RandomInt(0, 3);
        }
        n1.setText(name.values()[nf1].toString()+" и "+name.values()[nf2].toString()+
                " пропалывают грядку за " + i + " минут, а одна "+name.values()[nf1].toString()+" — за " + y + " минут. За сколько минут пропалывает грядку одна "+name.values()[nf2].toString()+"?");
        otv1 = (double) y * (double) i / ((double) y - (double) i);
        bn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on1);
                try {
                    if (Math.abs(otv1 - Double.parseDouble(on1.getText().toString())) < 0.00001d) {
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

        i = Generation.RandomMul(100);
        y = Math.abs(i+ Generation.RandomMul(100));
        while((i==y)||(i==0)||(y==0)||(i>y)){
            i = Generation.RandomMul(100);
            y = Math.abs(i+ Generation.RandomMul(100));
        }
        //      while (!Generation.CheckZn(y-i)||(i>=y)){
        //          y = Generation.RandomMul(100);
        //      }
        nf1= Generation.RandomInt(0,3);
        nf2= Generation.RandomInt(0,3);
        while (nf1==nf2) {
            nf2 = Generation.RandomInt(0, 3);
        }
        n2.setText(name.values()[nf1].toString()+" и "+name.values()[nf2].toString()+
                " пропалывают грядку за " + i + " минут, а одна "+name.values()[nf1].toString()+" — за " + y + " минут. За сколько минут пропалывает грядку одна "+name.values()[nf2].toString()+"?");
        otv2 = (double) y * (double) i / ((double) y - (double) i);
        bn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on2);
                try {
                    if (Math.abs(otv2 - Double.parseDouble(on2.getText().toString())) < 0.00001d) {
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

        int S,n,a1,an, d;
        a1 = Generation.RandomInt(1, 10);
        n = Generation.RandomInt(7, 15);
        if(n%2!=0)
            n = Generation.RandomInt(7, 15);
        d = Generation.RandomInt(2, 6);
        an=a1+d*(n-1);
        S=(a1+an)*n/2;
        n3.setText("Васе надо решить "+S+" задач. Ежедневно он решает на одно и то же количество задач больше по сравнению с предыдущим днем. " +
                "Известно, что за первый день Вася решил "+a1+" задач. Определите, сколько задач решил Вася в последний день, если со всеми задачами он справился за "+n+" дней.");
        otv3 = an;
        bn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on3);
                try {
                    if (Math.abs(otv3 - Double.parseDouble(on3.getText().toString())) < 0.00001d) {
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

        a1 = Generation.RandomInt(1, 10);
        n = Generation.RandomInt(7, 15);
        if(n%2!=0)
            n = Generation.RandomInt(10, 20);
        d = Generation.RandomInt(2, 6);
        an=a1+d*(n-1);
        S=(a1+an)*n/2;
        n4.setText("Васе надо решить "+S+" задач. Ежедневно он решает на одно и то же количество задач больше по сравнению с предыдущим днем. " +
                "Известно, что за первый день Вася решил "+a1+" задач. Определите, сколько задач решил Вася в последний день, если со всеми задачами он справился за "+n+" дней.");
        otv4 = an;
        bn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(on4);
                try {
                    if (Math.abs(otv4 - Double.parseDouble(on4.getText().toString())) < 0.00001d) {
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

        int x,c;
        int a,b;
        x = Generation.RandomInt(10, 20);
        c = Generation.RandomInt(10, 20);
        a = Generation.RandomMul(100);
        b = Math.abs(a-Generation.RandomMul(100));

        n5.setText("Сергей смешал раствор, содержащий "+x+"% кислоты и раствор, содержащий "+c+"% той же кислоты. " +
                "В итоге у него получился раствор, содержащий "+Math.round((((double)a*x+(double)b*c)/(double)(a+b))*100d)/100d+"% кислоты, причём объём полученного раствора "+(a+b)+" литра. " +
                "Сколько литров раствора, содержащего "+x+"% кислоты, использовал Сергей при смешивании? Ответ округлить до целых");
        otv5 = a;
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

        x = Generation.RandomInt(10, 20);
        c = Generation.RandomInt(10, 20);
        a = Generation.RandomMul(100);
        b = Math.abs(a-Generation.RandomMul(100));
        n6.setText("Сергей смешал раствор, содержащий "+x+"% кислоты и раствор, содержащий "+c+"% той же кислоты. " +
                "В итоге у него получился раствор, содержащий "+Math.round((((double)a*x+(double)b*c)/(double)(a+b))*100d)/100d+"% кислоты, причём объём полученного раствора "+(a+b)+" литра. " +
                "Сколько литров раствора, содержащего "+x+"% кислоты, использовал Сергей при смешивании? Ответ округлить до целых");
        otv6 = a;
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