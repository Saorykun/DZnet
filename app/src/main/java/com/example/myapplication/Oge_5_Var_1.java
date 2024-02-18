package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Oge_5_Var_1 implements Taskable {

    private final static String Id = "005";
    private Structure_Task task;



    public Structure_Task getTask(Generations generation) {
        int i, y, z;
        double otv1;

        i = Generation.RandomInt(5, 10);
        y = Generation.RandomInt(5, 12);
        otv1 = y * 60 / i;

        String text = String.format("Принтер печатает одну страницу за %s секунд. Какое наибольшее количество страниц можно напечатать на этом принтере за %s минут?", generation.checkAnswer(i), generation.checkAnswer(y));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(y * 60 / i);
        return task;
    }

    public static String getId() {
        return Id;
    }


}