package com.example.myapplication;

public class Oge_5_Var_4 implements Taskable {

    private final static String Id = "005";
    private Structure_Task task;

    public Structure_Task getTask(Generations generation) {
        int length, width;
        int area;
        length = Generation.RandomInt(3, 10);
        width = Generation.RandomInt(5, 15);
        area = length * width;
        String text = String.format("У вас есть прямоугольник с длиной %s см и шириной %s см. Найдите площадь этого прямоугольника.", generation.checkAnswer(length), generation.checkAnswer(width));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(area);
        return task;
    }

    public static String getId() {
        return Id;
    }
}
