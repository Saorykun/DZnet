package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tema1 extends AppCompatActivity {
    final private String Module = "1";

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
        setContentView(R.layout.activity_tema1);
        globalVariable.DelNum(Module);
        TextView C1 = findViewById(R.id.C1);
        TextView C2 = findViewById(R.id.C2);
        TextView Z1 = findViewById(R.id.Z1);
        TextView Z2 = findViewById(R.id.Z2);
        EditText OtvC = findViewById(R.id.OtvC);
        EditText OtvZ = findViewById(R.id.OtvZ);
        Button button = findViewById(R.id.button);
        TextView N2C1 = findViewById(R.id.N2C1);
        TextView N2C2 = findViewById(R.id.N2C2);
        TextView N2Z1 = findViewById(R.id.N2Z1);
        TextView N2Z2 = findViewById(R.id.N2Z2);
        EditText N2otvC = findViewById(R.id.N2otvC);
        EditText N2otvZ = findViewById(R.id.N2otvZ);
        Button Answ2 = findViewById(R.id.Answ2);
        ImageView chek1 = findViewById(R.id.chek1);
        ImageView chek2 = findViewById(R.id.chek2);
        ImageView chek3 = findViewById(R.id.chek3);
        int val = 0;
        int Answ2C;

        //№1
        //Числитель1 - рандом
        int i = Generation.RandomInt(1, 15);
        C1.setText(String.valueOf(i));
        val = val + i;

        //Числитель2 - рандом
        i = Generation.RandomInt(1, 15);
        C2.setText(String.valueOf(i));
        val = val + i;

        //Знаменатели = рандом
        i = Generation.RandomInt(31, 45);
        Z1.setText(String.valueOf(i));
        Z2.setText(String.valueOf(i));
        final int a1 = val;
        final int a2 = i;

        //№2
        i = Generation.RandomInt(16, 20);
        N2C1.setText(String.valueOf(i));
        Answ2C = i;

        i = Generation.RandomInt(1, 15);
        N2C2.setText(String.valueOf(i));
        Answ2C = Answ2C - i;

        i = Generation.RandomInt(30, 45);
        N2Z1.setText(String.valueOf(i));
        N2Z2.setText(String.valueOf(i));

        final int N2C = Answ2C;
        final int N2Z = i;

        //№3
        TextView N3C1 = findViewById(R.id.N3C1);
        TextView N3C2 = findViewById(R.id.N3C2);
        TextView N3C3 = findViewById(R.id.N3C3);
        TextView N3Z1 = findViewById(R.id.N3Z1);
        TextView N3Z2 = findViewById(R.id.N3Z2);
        TextView N3Z3 = findViewById(R.id.N3Z3);
        EditText N3otvC = findViewById(R.id.N3otvC);
        EditText N3otvZ = findViewById(R.id.N3otvZ);
        Button Answ3 = findViewById(R.id.answ3);

        int Answ3C = 0;
        i = Generation.RandomInt(10, 20);
        N3C1.setText(String.valueOf(i));
        Answ3C = i;
        i = Generation.RandomInt(1, 8);
        N3C2.setText(String.valueOf(i));
        Answ3C = Answ3C + i;
        i = Generation.RandomInt(1, 10);
        N3C3.setText(String.valueOf(i));
        Answ3C = Answ3C - i;
        i = Generation.RandomInt(20, 30);
        N3Z1.setText(String.valueOf(i));
        N3Z2.setText(String.valueOf(i));
        N3Z3.setText(String.valueOf(i));
        final int Answ3Z = i;
        final int AnswC = Answ3C;

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(OtvC);
                setLock(OtvZ);
                if ((String.valueOf(a1).equals(OtvC.getText().toString())) && (String.valueOf(a2).equals(OtvZ.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    chek1.setVisibility(View.VISIBLE);
                } else {
                    chek1.setImageResource(R.drawable.red);
                    chek1.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                button.setEnabled(false);

            }
        });

        Answ2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(N2otvC);
                setLock(N2otvZ);
                if ((String.valueOf(N2C).equals(N2otvC.getText().toString())) && (String.valueOf(N2Z).equals(N2otvZ.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    chek2.setVisibility(View.VISIBLE);
                } else {
                    chek2.setImageResource(R.drawable.red);
                    chek2.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                Answ2.setEnabled(false);
            }
        });

        Answ3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                setLock(N3otvC);
                setLock(N3otvZ);
                if ((String.valueOf(Answ3Z).equals(N3otvZ.getText().toString())) && (String.valueOf(AnswC).equals(N3otvC.getText().toString()))) {
                    globalVariable.NumTruePlus(Module);
                    chek3.setVisibility(View.VISIBLE);
                } else {
                    chek3.setImageResource(R.drawable.red);
                    chek3.setVisibility(View.VISIBLE);
                }
                Check(globalVariable);
                Answ3.setEnabled(false);
            }
        });
    }

    private void Check(GlobalClass globalVariable) {
        Intent i1 = new Intent(this, test.class);
        globalVariable.NumPlus(Module);
        if (globalVariable.GetNum(Module) == 3) {
            switch (globalVariable.GetNumTrue(Module)) {
                case (0): {
                    globalVariable.setModule(Module, 2);
                    break;
                }
                case (1): {
                    globalVariable.setModule(Module, 2);
                    break;
                }

                case (2): {
                    globalVariable.setModule(Module, 3);
                    break;
                }

                case (3): {
                    globalVariable.setModule(Module, 5);
                    break;
                }
            }
            globalVariable.DelNum(Module);
            startActivity(i1);
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

//Добавить переход в нужную активити
