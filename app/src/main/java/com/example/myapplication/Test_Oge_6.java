package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Test_Oge_6 extends AppCompatActivity implements GenerateLayout.SomeListener2 {

    public void loadRightAnswer2(String answer, Boolean rightAnswerPlus, Boolean onCheck, Boolean onCheckAll) {
        if (answer != "не меняй") {
            this.right_answers.add(answer);
        }
        if (rightAnswerPlus) {
            this.rightAnswer++;
        }
        if (onCheck) {
            Check();
        }
        if (onCheckAll) {
            CheckAll();
        }
    }

    //Tmp var
    StructureGen structureGen;

    //Ever var
    ArrayList<String> right_answers = new ArrayList<>();
    int volAnswer = 0;
    int rightAnswer = 0;

    //Self var
    String Module = "006"; //Модуль - это критерий по которому генерируются только вариации одного номера заданий из огэ
    //исключает Enter_task, то есть все равно какой он

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oge6);

        String seedVol = "";

        String[] Enter_task = {"006"};

        ArrayList<String> Var_task = new ArrayList<>();
        ArrayList<Integer> Vol_task = new ArrayList<>();

        Var_task.add("r");
        Vol_task.add(10);

        int n = Enter_task.length;
        ArrayList<EnterVarVol> enterVarVols = new ArrayList<EnterVarVol>();
        for (int i = 0; i < n; i++) {
            enterVarVols.add(new EnterVarVol(Enter_task[i], Var_task, Vol_task));
        }
        this.structureGen = new StructureGen(enterVarVols, seedVol);

        GenerateSeed generateSeed = new GenerateSeed();
        Generations generations = generateSeed.generationSeed(structureGen);
        GenerateLayout generateLayout = new GenerateLayout(getApplicationContext(), generations, this.structureGen, Module);
        generateLayout.setListener2(this);
        setContentView(generateLayout.createLayout());
    }

    private void Check() {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        Intent intent = new Intent(this, test.class);
        volAnswer++;
        int sumMaxAnswer = 0;
        sumMaxAnswer = structureGen.getSumAllVol();
        if (volAnswer == sumMaxAnswer) {
            globalVariable.setModule(Module, (int) ((double) rightAnswer / sumMaxAnswer * 100));
            startActivity(intent);
            finish();
        }
    }

    private void CheckAll() {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        Intent intent = new Intent(this, test.class);
        int sumMaxAnswer = 0;
        sumMaxAnswer = structureGen.getSumAllVol();
        globalVariable.setModule(Module, (int) ((double) rightAnswer / sumMaxAnswer * 100));
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
    }
}

