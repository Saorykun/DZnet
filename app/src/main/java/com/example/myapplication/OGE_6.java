package com.example.myapplication;

import com.example.myapplication.Generation;

import java.util.Random;

public class OGE_6 implements Taskable{

    private final String Id = "ОГЭ_6";
    private Structure_Task task;
    private Generations generation;

    OGE_6(Generations generation){
        this.generation=generation;
    }

    public Structure_Task getTask(){
        float[] nums = new float[generation.RandomInt(3,5)];
        for(int i=0;i<nums.length;i++){
            nums[i]= (float) generation.RandomDouble(1,5, 1);
        }
        float answer=nums[0];
        String text =""+nums[0];
        for(int i=1;i<nums.length;i++){
            switch (generation.RandomInt(1,4)){
                case(1):    //+
                    answer+=nums[i];
                    text+="+"+nums[i];
                    break;
                case(2):
                    answer*=nums[i];
                    if(i==1){
                        text=text+"*"+nums[i];
                    }
                    else{
                        text="("+text+")"+"*"+nums[i];
                    }
                    break;
                case(3):
                    answer-=nums[i];
                    text+="-"+nums[i];
                    break;
            }
        }
        String answer1;
        if(generation.RandomInt(1,2)==1){
            text = "Вычислить: "+ text+"\nОтвет округли до целых";
            answer1 = Integer.toString(Math.round(answer));
        }
        else{
            text = "Вычислить: "+ text+"\nОтвет округли до десятых";
            if(generation.isInt((float)(Math.round(answer*10))/10))
                answer1=Integer.toString(Math.round(Math.round(answer*10)/10));
            else
                answer1 = Float.toString((float)(Math.round(answer*10))/10);
        }
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(answer1);
        return task;
    }

    Structure_Task var_2(){
        int i = generation.RandomInt(2, 8);
        int r = generation.RandomInt(2, 8);
        int answer = r;
        int p=i*i*r;
        String text = "Мощность2 постоянного тока (в ваттах) вычисляется по формуле " +
                "P=I"+ "\u00B2"+"R, где I— сила тока (в амперах), R — сопротивление (в омах). " +
                "Пользуясь этой формулой, найдите R (в омах), если P="+p+"Вт и I="+i+"А.";
        task = new Structure_Task();
        task.setId(1);
        task.setText(text);
        task.setAnswer(Double.toString(answer));
        return task;
    }

    public static String getIdTask(){
        return "ОГЭ_6";
    }
}