package com.example.myapplication.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.EnterVarVol;
import com.example.myapplication.GenerateLayout;
import com.example.myapplication.GenerateSeed;
import com.example.myapplication.Generations;
import com.example.myapplication.GlobalClass;
import com.example.myapplication.R;
import com.example.myapplication.SVM;
import com.example.myapplication.StructureGen;
import com.example.myapplication.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_Ind extends AppCompatActivity implements GenerateLayout.SomeListener2 {

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

    StructureGen structureGen;

    //Ever var
    ArrayList<String> right_answers = new ArrayList<>();
    int volAnswer = 0;
    int rightAnswer = 0;
    Classificator classificator;
    SVM svm;
    //Self var
    String Module; //Модуль - это критерий по которому генерируются только вариации одного номера заданий из огэ
    //исключает Enter_task, то есть все равно какой он

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ind);

        String seedVol = "";
        ArrayList<ArrayList<String>> Problem_Task;
        Intent intent = getIntent();
        if (intent.getStringExtra("switch").equals("1")){
            this.classificator = new Classificator();
            Problem_Task=classificator.getProblemTask(getApplicationContext());
            classificator = null;
        }else{
            this.svm = new SVM();
            Problem_Task=svm.getProblemTask(getApplicationContext());
            svm = null;
        }


        ArrayList<String> Enter_task = Problem_Task.get(0);
        ArrayList<String> Var_task = new ArrayList<>();
        ArrayList<Integer> Vol_task = new ArrayList<>();

        for(int i =0;i<Problem_Task.get(0).size();i++){
            Var_task.add("r");
            Vol_task.add(Integer.parseInt(Problem_Task.get(1).get(i)));
        }

        int n = Enter_task.size();
        ArrayList<EnterVarVol> enterVarVols = new ArrayList<EnterVarVol>();
        for (int i = 0; i < n; i++) {
            enterVarVols.add(new EnterVarVol(Enter_task.get(i), new ArrayList<>(Arrays.asList(String.valueOf(Var_task.get(i)))), new ArrayList<>(Arrays.asList(Vol_task.get(i)))));
        }
        this.structureGen = new StructureGen(enterVarVols, seedVol);

        GenerateSeed generateSeed = new GenerateSeed();
        Generations generations = generateSeed.generationSeed(structureGen);
        GenerateLayout generateLayout = new GenerateLayout(getApplicationContext(), generations, this.structureGen, Module);
        generateLayout.setListener2((GenerateLayout.SomeListener2) this);
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
}