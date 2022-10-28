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
    String[] Enter_task={"6","6"};
    int[] Var_task={1,1};
    int[] Vol_task={1,1};
    String seedVol="0";

    //Ever var
    ArrayList<String> right_answers = new ArrayList<>();;
    int volAnswer =0;
    int rightAnswer =0;

    //Self var
    String Module ="ОГЭ_6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oge6);

        GenerateSeed generateSeed = new GenerateSeed();
        Generations generations = generateSeed.generationSeed(seedVol,Enter_task,Vol_task);
        GenerateLayout generateLayout = new GenerateLayout(getApplicationContext(),generations,Enter_task,Vol_task,Var_task,Module);
        generateLayout.setListener2(this);
        setContentView(generateLayout.createLayout());
        int i=0;
    }

    private void Check() {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        Intent intent = new Intent(this, test.class);
        volAnswer++;
        int sumMaxAnswer=0;
        for(int i =0;i<Vol_task.length;i++)
            sumMaxAnswer+=Vol_task[i];
        if (volAnswer == sumMaxAnswer) {
            globalVariable.setModule(Module, (int)((double)rightAnswer/volAnswer*100));
            startActivity(intent);
            finish();
        }
    }

}

