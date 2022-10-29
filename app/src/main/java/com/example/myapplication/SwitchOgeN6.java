package com.example.myapplication;

public class SwitchOgeN6 {

//    public static String getIdTask(){
//        return "ОГЭ_6";
//    }
    public static Structure_Task getTask(int var, Generations generations){
        switch (var){
            case(1):{
                Oge_6_Var_1 oge_6 = new Oge_6_Var_1(generations);
                Structure_Task struct = oge_6.getTask();
                return struct;
            }
            default:{
                Oge_6_Var_1 oge_6 = new Oge_6_Var_1(generations);
                Structure_Task struct = oge_6.getTask();
                return struct;
            }
        }
    }
}
