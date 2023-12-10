package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class GenerateLayout implements CreateStructureTask.SomeListener1 {

    public void loadRightAnswer(String answer, Boolean rightAnswerPlus, Boolean onCheck, Boolean onCheckAll) {
        listener.loadRightAnswer2(answer, rightAnswerPlus, onCheck, onCheckAll);
    }

    SomeListener2 listener;

    public interface SomeListener2 {
        void loadRightAnswer2(String answer, Boolean rightAnswerPlus, Boolean onCheck, Boolean onCheckAll);
    }

    public void setListener2(SomeListener2 listener) {
        this.listener = listener;
    }

    public GenerateLayout(Context context, Generations generations, StructureGen structureGen, String module) {
        this.context = context;
        this.generations = generations;
        this.module = module;
        this.structureGen = structureGen;
    }

    String tmpAnswer;
    ArrayList<String> right_answers;
    LinearLayout god;
    Generations generations;
    Context context;
    String module;
    StructureGen structureGen;

    public ScrollView createLayout() {
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
        CreateStructureTask structureTask = new CreateStructureTask();
        god.addView(structureTask.infoForTest(context, generations));
        scr.addView(god);
        generationOrder();
        return scr;
    }

    private void generationOrder() {
        for (int i = 0; i < structureGen.getEnterVarVol().size(); i++) {
            for (int r = 0; r < structureGen.getEnterVarVol().get(i).getVar().size(); r++) {
                for (int j = 0; j < structureGen.getEnterVarVol().get(i).getVol().get(r); j++) {
                    CreateStructureTask structureTask = new CreateStructureTask();
                    structureTask.setListener(this);
                    listener.loadRightAnswer2(tmpAnswer, false, false, false);
                    god.addView(structureTask.getStructure(context, structureGen.getEnterVarVol().get(i).getName(), structureGen.getEnterVarVol().get(i).getVar().get(r), generations, module));
                    addLineSeperator(god);
                }
            }
        }
        CreateStructureTask structureTask = new CreateStructureTask();
        structureTask.setListener(this);
        god.addView(structureTask.getFinishButton(context));
    }

    private static int convertPrToPixel(float pr) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = (metrics.widthPixels) * pr / 100;
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

    public static LinearLayout lineSeperator(Context context) {
        LinearLayout lineLayout = new LinearLayout(context);
        lineLayout.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2);
        params.setMargins(convertPrToPixel(5), convertPrToPixel(2), convertPrToPixel(5), convertPrToPixel(2));
        lineLayout.setLayoutParams(params);
        return lineLayout;
    }

}
