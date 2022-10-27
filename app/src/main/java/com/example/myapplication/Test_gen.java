package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Test_gen{
//
//    LinearLayout god;
//    ArrayList<Integer> right_answer;
//    ArrayList<Integer> buttonId;
//
//    Test_gen(){    }
//
//    public ArrayList<Integer> getRight_answer(){
//        return this.right_answer;
//    }
//
//    public ArrayList<Integer> getButtonId(){
//        return this.buttonId;
//    }
//
//    public ScrollView getGen(Context context) {
//        god = new LinearLayout(context);
//        god.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams LP = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        god.setLayoutParams(LP);
//        god.setId(View.generateViewId());
//        buttonId = new ArrayList<>();
//        right_answer = new ArrayList<>();
//
//        //GENERATING TEST
//        for(int i=0;i<5;i++){
//            god.addView(gen(context));
//            addLineSeperator(god,context);
//        }
//
//        //GOD to SCROLL
//        ScrollView scr = new ScrollView(context);
//        scr.addView(god);
//        return scr;
//
//
//    }
//
////    private void GEN(Category_Task... var){
////        for(int i=1; i<var.length;i++){
////
////            for(int j=var[i].getVol();j!=0;j--) {
////                god.addView(gen(var[i].getVar()));
////                addLineSeperator(god);
////            }
////        }
////    }
//
//    private LinearLayout gen(Context context){
//        OGE_6 task = new OGE_6();
//        return gen((int) (Math.random()*task.getSum_num()+1),context);
//    }
//    private LinearLayout gen(int var_task,Context context){
//        OGE_6 task = new OGE_6(1);
//        Structure_Task struct = task.getTask();
//        this.right_answer.add(task.getTask().getAnswer());
//
//        //Linear
//        LinearLayout ll = new LinearLayout(context);
//        ll.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout hh = new LinearLayout(context);
//        hh.setOrientation(LinearLayout.HORIZONTAL);
//        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        ll.setLayoutParams(llLP);
//        LinearLayout.LayoutParams hhLP = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        hh.setGravity(Gravity.RIGHT);
//        hh.setLayoutParams(hhLP);
//
//        //Textview
//        TextView tv = new TextView(context);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        tv.setLayoutParams(lp);
//        tv.setText(struct.getText());
//        tv.setPadding(32, 32, 32, 8);
//        tv.setTextAppearance(R.style.Task);
//        ll.addView(tv);
//
//        EditText et = new EditText(context);
//        LinearLayout.LayoutParams edd = new LinearLayout.LayoutParams(
//                convertPrToPixel(60),
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        et.setLayoutParams(edd);
//        et.setHint("answer");
//        et.setPadding(8, 8, 8, 8);
//        hh.addView(et);
//
//        Button bt = new Button(context);
//        bt.setId(View.generateViewId());
//        this.buttonId.add(bt.getId());
//        bt.setText("Click");
//        bt.setPadding(8, 8, 8, 8);
//        for(int i=0;i<buttonId.size();i++){
//            bt.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    final GlobalClass globalVariable = (GlobalClass) context;
//                    setLock(et);
//                    try {
//                        if (Math.abs(right_answer.get(i) - Double.parseDouble(et.getText().toString()))<0.001d) {
//                            globalVariable.NumTruePlus(Module);
////                            check1.setVisibility(View.VISIBLE);
//                        } else {
//                            throw new Exception();
//                        }
//                    }
//                    catch (Exception ex) {
////                        check1.setImageResource(R.drawable.red);
////                        check1.setVisibility(View.VISIBLE);
//                    }
//                    Check(globalVariable);
//                    bt.setEnabled(false);
//                }
//            });
//        }
//
//
//        hh.addView(bt);
//        ll.addView(hh);
//        return ll;
//    }
//
//    private int convertPrToPixel(float pr) {
//        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
//        float px = (metrics.widthPixels)*pr/100;
//        return Math.round(px);
//    }
//    private void addLineSeperator(LinearLayout linearLayout,Context context) {
//        LinearLayout lineLayout = new LinearLayout(context);
//        lineLayout.setBackgroundColor(Color.GRAY);
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                2);
//        params.setMargins(convertPrToPixel(5), convertPrToPixel(2), convertPrToPixel(5), convertPrToPixel(2));
//        lineLayout.setLayoutParams(params);
//        linearLayout.addView(lineLayout);
//    }
//    private void Check(GlobalClass globalVariable) {
//        Intent i = new Intent(this, test.class);
//        globalVariable.NumPlus(Module);
//        if (globalVariable.GetNum(Module) == 6) {
//            switch (globalVariable.GetNumTrue(Module)) {
//                case (0):
//                case (1):
//                case (2): {
//                    globalVariable.setModule(Module, 2);
//                    break;
//                }
//                case (3):
//                case (4): {
//                    globalVariable.setModule(Module, 3);
//                    break;
//                }
//                case (5): {
//                    globalVariable.setModule(Module, 4);
//                    break;
//                }
//                case (6): {
//                    globalVariable.setModule(Module, 5);
//                    break;
//                }
//            }
//            globalVariable.DelNum(Module);
//            startActivity(i);
//            finish();
//        }
//    }
//
//    private void setLock(EditText context) {
//        context.setEnabled(false);
//        context.setCursorVisible(false);
//    }

}
