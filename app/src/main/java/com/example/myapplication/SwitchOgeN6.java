package com.example.myapplication;

public class SwitchOgeN6 {

//    public static String getIdTask(){
//        return "ОГЭ_6";
//    }
    public static Structure_Task getTask(int var, Generations generations){
        switch (var){
            case(1):{
                OGE_6 oge_6 = new OGE_6(generations);
                Structure_Task struct = oge_6.getTask();
                return struct;
            }
            default:{
                OGE_6 oge_6 = new OGE_6(generations);
                Structure_Task struct = oge_6.getTask();
                return struct;
            }
        }
    }
}
