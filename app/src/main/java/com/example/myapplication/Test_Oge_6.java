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

public class Test_Oge_6 extends AppCompatActivity {

    //Tmp var
    int[] Enter_task={1,2};
    int[] Vol_task={1,1};
    String seedVol="0";

    //Ever var
    LinearLayout god;
    ArrayList<String> right_answers;
    Generations generation;
    int volAnswer =0;
    int rightAnswer =0;
    String seed;

    //Self var
    int Module =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_oge6);
        god = new LinearLayout(this);
        god.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        god.setLayoutParams(LP);
        god.setId(View.generateViewId());
        right_answers = new ArrayList<>();
        //GENERATING TEST
        GEN();
        //GOD to SCROLL
        ScrollView scr = new ScrollView(this);
        scr.addView(god);
        setContentView(scr);

    }

    private void GEN(){
        Shifr_To_Seed shifr_to_seed = new Shifr_To_Seed();
        if(seedVol=="0"){
            Boolean flag=true;
            int k=0;
            int[] mass = new int[Enter_task.length*2+1];
            this.seed = Integer.toString((int) System.currentTimeMillis());
            for(int i=0; i<Enter_task.length*2+1;i++){
                if(i==0){
                    mass[i]=Integer.parseInt(seed);
                }
                else{
                    if(flag){
                        mass[i]=Enter_task[k];
                        flag=!flag;
                    }
                    else{
                        mass[i]=Vol_task[k];
                        flag=!flag;
                        k++;
                    }
                }
            }

            this.seed=shifr_to_seed.unity(mass);
        }
        else{
            Vol_task= shifr_to_seed.getVol_task(seedVol);
            Enter_task=shifr_to_seed.getEnter_task(seedVol);
            this.seed=seedVol;
        }
        generation = new Generations(seed);
        for(int i=0; i<Enter_task.length;i++){
            for(int j=Vol_task[i];j!=0;j--) {
                god.addView(gen(Enter_task[i],generation));
                addLineSeperator(god);
            }
        }
    }

    private LinearLayout gen(){
        OGE_6 tmp_task = new OGE_6();
        return gen((int) (Math.random()*tmp_task.getSum_num()+1),generation);
    }
    private LinearLayout gen(Boolean b,Generations generation){
        OGE_6 tmp_task = new OGE_6();
        return gen((int) (Math.random()*tmp_task.getSum_num()+1),generation);
    }
    private LinearLayout gen(int var_task,Boolean b){
        return gen(var_task,generation);
    }
    private LinearLayout gen(int var_task,Generations generation){
        OGE_6 task = new OGE_6(var_task,generation);
        Structure_Task struct = task.getTask();
        this.right_answers.add(task.getTask().getAnswer());


        //Linear
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout hh = new LinearLayout(this);
        hh.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llLP);
        LinearLayout.LayoutParams hhLP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        hh.setGravity(Gravity.RIGHT);
        hh.setPadding(0,0,32,0);
        hh.setLayoutParams(hhLP);

        //Textview
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText(struct.getText());
        tv.setPadding(32, 32, 32, 8);
        tv.setTextAppearance(R.style.Task);
        ll.addView(tv);

        //ImageView
        ImageView iv = new ImageView(this);
        LinearLayout.LayoutParams ivLP = new LinearLayout.LayoutParams(
                convertPrToPixel(10),
                convertPrToPixel(10));
        iv.setLayoutParams(ivLP);
        iv.setPadding(32,8,8,8);
        iv.setImageResource(R.drawable.green);
        iv.setVisibility(View.INVISIBLE);
        hh.addView(iv);

        //EditText
        EditText et = new EditText(this);
        LinearLayout.LayoutParams edd = new LinearLayout.LayoutParams(
                convertPrToPixel(60),
                LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(edd);
        et.setHint("answer");
        et.setPadding(8, 8, 8, 8);
        hh.addView(et);

        //Button
        Button bt = new Button(this);
        bt.setId(View.generateViewId());
        bt.setText("Click");
        bt.setPadding(8, 8, 8, 8);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Boolean flag = true;
                setLock(et);
                String answer;
                answer=task.getTask().getAnswer();
                if (answer.equals(et.getText().toString())) {
                    if(flag) {
                        rightAnswer++;
                        iv.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    iv.setImageResource(R.drawable.red);
                    iv.setVisibility(View.VISIBLE);
                }
                Check();
                et.setEnabled(false);
            }
        });
        hh.addView(bt);
        ll.addView(hh);
        return ll;
    }

    private int convertPrToPixel(float pr) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = (metrics.widthPixels)*pr/100;
        return Math.round(px);
    }
    private void addLineSeperator(LinearLayout linearLayout) {
        LinearLayout lineLayout = new LinearLayout(this);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(convertPrToPixel(5), convertPrToPixel(2), convertPrToPixel(5), convertPrToPixel(2));
        lineLayout.setLayoutParams(params);
        linearLayout.addView(lineLayout);
    }

    private void setLock(EditText context) {
        context.setEnabled(false);
        context.setCursorVisible(false);
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

