package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class GenerateLayout implements CreateStructureTask.SomeListener1{

    public void loadRightAnswer(String answer,Boolean rightAnswerPlus,Boolean onCheck){
        listener.loadRightAnswer2(answer,rightAnswerPlus,onCheck);
    }

    SomeListener2 listener;

    interface SomeListener2 {
        void loadRightAnswer2(String answer,Boolean rightAnswerPlus,Boolean onCheck);
    }

    public void setListener2(SomeListener2 listener){
        this.listener = listener;
    }

    String tmpAnswer;
    ArrayList<String> right_answers;
    LinearLayout god;
    String[] enter_task;
    int[] vol_task;
    Generations generations;
    Context context;
    String module;
    int[] var_task;

    GenerateLayout(Context context,Generations generations, String[] enter_task, int[] vol_task, int[] var_task, String module){
        this.context = context;
        this.generations=generations;
        this.enter_task=enter_task;
        this.vol_task=vol_task;
        this.module=module;
        this.var_task=var_task;
    }

    public ScrollView createLayout(){
        god = new LinearLayout(context);
        god.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        god.setLayoutParams(LP);
        god.setId(View.generateViewId());
        right_answers = new ArrayList<>();
        //GOD to SCROLL
        ScrollView scr = new ScrollView(context);
        scr.addView(god);
        generationOrder();
        return scr;
    }
    private void generationOrder(){
        for(int i=0; i<enter_task.length;i++){
            for(int j=vol_task[i];j!=0;j--) {
                CreateStructureTask structureTask = new CreateStructureTask();
                structureTask.setListener(this);
                listener.loadRightAnswer2(tmpAnswer,false,false);
                god.addView(structureTask.getStructure(context,enter_task[i],var_task[i],generations,module));
                addLineSeperator(god);
            }
        }
    }



    private int convertPrToPixel(float pr) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = (metrics.widthPixels)*pr/100;
        return Math.round(px);
    }

    private void addLineSeperator(LinearLayout linearLayout) {
        LinearLayout lineLayout = new LinearLayout(context);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(convertPrToPixel(5), convertPrToPixel(2), convertPrToPixel(5), convertPrToPixel(2));
        lineLayout.setLayoutParams(params);
        linearLayout.addView(lineLayout);
    }

}
