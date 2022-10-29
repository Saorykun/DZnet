package com.example.myapplication;

public class SwitchModule {

    SwitchModule(){}

    public Structure_Task getTask(String module, String var, Generations generations){
        switch (module){
            case("006"):{
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
