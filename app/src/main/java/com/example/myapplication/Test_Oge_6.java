package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class Test_Oge_6 extends AppCompatActivity implements GenerateLayout.SomeListener2{

    public void loadRightAnswer2(String answer,Boolean rightAnswerPlus,Boolean onCheck){
        if(answer!="не меняй"){
            this.right_answers.add(answer);
        }
        if(rightAnswerPlus){
            this.rightAnswer++;
        }
        if(onCheck){
            Check();
        }
    }
    //Tmp var
    StructureGen structureGen;

    //Ever var
    ArrayList<String> right_answers = new ArrayList<>();;
    int volAnswer =0;
    int rightAnswer =0;

    //Self var
    String Module ="ОГЭ_6"; //Модуль - это критерий по которому генерируются только вариации одного номера заданий из огэ
                            //исключает Enter_task, то есть все равно какой он

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oge6);

        String seedVol="";

        String[] Enter_task={"g6","g6","g6"};

        ArrayList<Integer> Var_task = new ArrayList<>();
        ArrayList<Integer> Vol_task= new ArrayList<>();

        Var_task.add(1);
        Vol_task.add(1);
        Var_task.add(1);
        Vol_task.add(1);

        int n=3;
        ArrayList<EnterVarVol> enterVarVols =new ArrayList<EnterVarVol>();
        for(int i=0;i<n;i++){
            enterVarVols.add(new EnterVarVol(Enter_task[i],Var_task,Vol_task));
        }
        this.structureGen=new StructureGen(enterVarVols,seedVol);

        GenerateSeed generateSeed = new GenerateSeed();
        Generations generations = generateSeed.generationSeed(structureGen);
        GenerateLayout generateLayout = new GenerateLayout(getApplicationContext(),generations,this.structureGen,Module);
        generateLayout.setListener2(this);
        setContentView(generateLayout.createLayout());
        int i=0;
    }

    private void Check() {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        Intent intent = new Intent(this, test.class);
        volAnswer++;
        int sumMaxAnswer=0;
        sumMaxAnswer=structureGen.getSumAllVol();
        if (volAnswer == sumMaxAnswer) {
            globalVariable.setModule(Module, (int)((double)rightAnswer/volAnswer*100));
            startActivity(intent);
            finish();
        }
    }

}

