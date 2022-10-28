package com.example.myapplication;

public class SwitchModule {

    SwitchModule(){}

    public Structure_Task getTask(String module, int var, Generations generations){
        switch (module){
            case("ОГЭ_6"):{
                Structure_Task struct = SwitchOgeN6.getTask(var,generations);
                return struct;
            }
            default:{
                Structure_Task struct = SwitchOgeN6.getTask(var,generations);
                return struct;
            }
        }
    }


}
