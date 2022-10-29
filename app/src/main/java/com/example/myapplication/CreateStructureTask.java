package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateStructureTask {

    SomeListener1 listener;

    interface SomeListener1 {
        void loadRightAnswer(String answer,Boolean rightAnswerPlus,Boolean onCheck);
    }

    public void setListener(SomeListener1 listener){
        this.listener = listener;
    }

    CreateStructureTask(){
    }

    String enter_task;
    Generations generations;
    Context context;
    String module;
    String tmpAnswer;
    int var_task;

    public LinearLayout getStructure(Context context,String enter_task,int var_task,Generations generations, String module){
        this.module=module;
        this.context=context;
        this.generations=generations;
        this.enter_task=enter_task;
        this.var_task=var_task;

        if(module!="") {
            enter_task=module;
        }

        //Создание таска
        SwitchModule switchModule = new SwitchModule();
        Structure_Task struct = switchModule.getTask(enter_task, var_task, generations);
        //Из таска забрать ответы и отправить в тест
        this.tmpAnswer=struct.getAnswer();
        listener.loadRightAnswer(tmpAnswer,false,false);

        //Linear
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout hh = new LinearLayout(context);
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
        TextView tv = new TextView(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText(struct.getText());
        tv.setPadding(32, 32, 32, 8);
        tv.setTextAppearance(R.style.Task);
        ll.addView(tv);

        //ImageView
        ImageView iv = new ImageView(context);
        LinearLayout.LayoutParams ivLP = new LinearLayout.LayoutParams(
                convertPrToPixel(10),
                convertPrToPixel(10));
        iv.setLayoutParams(ivLP);
        iv.setPadding(32,8,8,8);
        iv.setImageResource(R.drawable.green);
        iv.setVisibility(View.INVISIBLE);
        hh.addView(iv);

        //EditText
        EditText et = new EditText(context);
        LinearLayout.LayoutParams edd = new LinearLayout.LayoutParams(
                convertPrToPixel(60),
                LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(edd);
        et.setHint("answer");
        et.setPadding(8, 8, 8, 8);
        hh.addView(et);

        //Button
        Button bt = new Button(context);
        bt.setId(View.generateViewId());
        bt.setText("Click");
        bt.setPadding(8, 8, 8, 8);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Boolean flag = true;
                String answer;
                setLock(et);
                if (tmpAnswer.equals(et.getText().toString())) {
                    if(flag) {
                        rightAnswerTask(iv);
                    }
                }
                else{
                    wrongAnswerTask(iv);
                }
                listener.loadRightAnswer("",false,true);
                et.setEnabled(false);
            }
        });

        hh.addView(bt);
        ll.addView(hh);
        return ll;
    }

    private void rightAnswerTask(ImageView iv){
        listener.loadRightAnswer("не меняй",true,false);
        iv.setImageResource(R.drawable.green);
        iv.setVisibility(View.VISIBLE);
        final GlobalClass globalVariable = (GlobalClass) context;
        globalVariable.setRightAnswerPlus(module,1);
        globalVariable.setVolAnswerPlus(module,1);
    }

    private void wrongAnswerTask(ImageView iv){
        iv.setImageResource(R.drawable.red);
        iv.setVisibility(View.VISIBLE);
        final GlobalClass globalVariable = (GlobalClass) context;
        globalVariable.setVolAnswerPlus(module,1);
    }

    private void setLock(EditText context) {
        context.setEnabled(false);
        context.setCursorVisible(false);
    }

    private int convertPrToPixel(float pr) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = (metrics.widthPixels)*pr/100;
        return Math.round(px);
    }

}
