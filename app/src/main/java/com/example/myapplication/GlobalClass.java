package com.example.myapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GlobalClass extends Application {
    private final int[] module= new int[200];
    private final int[] attempt= new int[200];
    private int Num = 0;
    private int NumTrue = 0;

    public Boolean getModeAttempt() {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getBoolean("AttemptMode",false);
    }

    public void setModeAttempt(Boolean b) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putBoolean("AttemptMode", b);
        myEditor.commit();
    }

    public boolean isBlind() {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getBoolean("blind", false);
    }

    public void setBlind(boolean blind) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putBoolean("blind", blind);
        myEditor.commit();
    }

    public int amtModule() {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        int a = 0;
        for (int i = 0; i < 200; i++) {
            if(myPreferences.getInt("tema" + i, 0)!=0) {
                a++;
            }
        }
        return a;
    }

    public void NumPlus(int number_module){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_Num"+ number_module, myPreferences.getInt("tema_Num"+ number_module,0)+1);
        myEditor.commit();
    }
    public int GetNum(int number_module){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_Num"+ number_module,0);
    }
    public void NumTruePlus(int number_module){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_NumTrue"+ number_module, myPreferences.getInt("tema_NumTrue"+ number_module,0)+1);
        myEditor.commit();
    }
    public int GetNumTrue(int number_module){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_NumTrue"+ number_module,0);
    }
    public void DelNum(int number_module){
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_NumTrue"+ number_module, 0);
        myEditor.putInt("tema_Num"+ number_module, 0);
        myEditor.commit();
    }
    public int getModule(int number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        module[number_module] = myPreferences.getInt("tema"+ number_module,0);
        return module[number_module];
    }
    public void setModule(int number_module, int estimation) {
        module[number_module] = estimation;
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt(("tema"+ number_module), estimation);
        myEditor.commit();
    }
    public int getAttempt(int number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_attempt"+ number_module,0);
    }
    public void setAttempt(int number_module, int number) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        attempt[number_module] = number;
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt(("tema_attempt"+ number_module), attempt[number_module]);
        myEditor.commit();
    }
    public void setAttemptPlus(int number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_attempt"+ number_module, myPreferences.getInt("tema_attempt"+ number_module,0)+1);
        myEditor.commit();
    }
}
