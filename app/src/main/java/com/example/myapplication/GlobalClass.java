package com.example.myapplication;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class GlobalClass extends Application {

    //Сохранение, увеличение и возврат КОЛИЧЕСТВА ВЕРНО РЕШЕННЫХ
    public void setRightAnswer(String module, int estimation) {                                       //Установление
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("RightAnswer" + module, estimation);
        myEditor.commit();
    }

    public int getRightAnswer(String module, int estimation) {                                        //Возврат
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("RightAnswer" + module, 0);
    }

    public void setRightAnswerPlus(String module, int estimation) {                                   //Добавление к существующим
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        try {
            myEditor.putInt("RightAnswer" + module, myPreferences.getInt("RightAnswer" + module, 0) + estimation);
        } catch (Exception ex) {
            myEditor.putInt("RightAnswer" + module, 0);
            myEditor.putInt("RightAnswer" + module, myPreferences.getInt("RightAnswer" + module, 0) + estimation);
        }
        myEditor.commit();
    }

    //Сохранение, увеличение и возврат КОЛИЧЕСТВА ВЕРНО РЕШЕННЫХ
    public void setVolAnswer(String module, int estimation) {                                       //Установление
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("VolAnswer" + module, estimation);
        myEditor.commit();
    }

    public int getVolAnswer(String module, int estimation) {                                        //Возврат
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("VolAnswer" + module, 0);
    }

    public void setVolAnswerPlus(String module, int estimation) {                                   //Добавление к существующим
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        try {
            myEditor.putInt("VolAnswer" + module, myPreferences.getInt("VolAnswer" + module, 0) + estimation);
        } catch (Exception ex) {
            myEditor.putInt("VolAnswer" + module, 0);
            myEditor.putInt("VolAnswer" + module, myPreferences.getInt("VolAnswer" + module, 0) + estimation);
        }
        myEditor.commit();
    }

    //Режим попыток
    public Boolean getModeAttempt() {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getBoolean("AttemptMode", false);
    }

    public void setModeAttempt(Boolean b) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putBoolean("AttemptMode", b);
        myEditor.commit();
    }

    //Режим цветовой слепоты
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

    //Установка и получение БАЛЛОВ
    public int getModule(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema" + number_module, 0);
    }

    public void setModule(String number_module, int estimation) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt(("tema" + number_module), estimation);
        myEditor.commit();
    }

    //Установление, получение и увеличение ПОПЫТОК
    public int getAttempt(int number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_attempt" + number_module, 0);
    }

    public void setAttempt(int number_module, int number) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt(("tema_attempt" + number_module), number);
        myEditor.commit();
    }

    public void setAttemptMinus(int number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_attempt" + number_module, myPreferences.getInt("tema_attempt" + number_module, 0) - 1);
        myEditor.commit();
    }

    //ХРЕН ЗНАЕТ ЧТО
    public int amtModule() {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        int a = 0;
        for (int i = 0; i < 200; i++) {
            if (myPreferences.getInt("tema" + i, 0) != 0) {
                a++;
            }
        }
        return a;
    }

    //Удалить скоро
    public void DelNum(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_NumTrue" + number_module, 0);
        myEditor.putInt("tema_Num" + number_module, 0);
        myEditor.commit();
    }

    public void NumPlus(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_Num" + number_module, myPreferences.getInt("tema_Num" + number_module, 0) + 1);
        myEditor.commit();
    }

    public int GetNum(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_Num" + number_module, 0);
    }

    public void NumTruePlus(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("tema_NumTrue" + number_module, myPreferences.getInt("tema_NumTrue" + number_module, 0) + 1);
        myEditor.commit();
    }

    public int GetNumTrue(String number_module) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(this);
        return myPreferences.getInt("tema_NumTrue" + number_module, 0);
    }
//Удалить
}
