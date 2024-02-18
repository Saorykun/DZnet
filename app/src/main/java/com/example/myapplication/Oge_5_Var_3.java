package com.example.myapplication;

public class Oge_5_Var_3 implements Taskable {

    private final static String Id = "005";
    private Structure_Task task;

    public Structure_Task getTask(Generations generation) {
        int radius, height;
        double volume;

        radius = Generation.RandomInt(3, 10);
        height = Generation.RandomInt(5, 15);

        volume = Math.PI * Math.pow(radius, 2) * height;

        String text = String.format("У вас есть цилиндр с радиусом основания %s см и высотой %s см. Найдите объем этого цилиндра.", generation.checkAnswer(radius), generation.checkAnswer(height));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(volume);
        return task;

    }

    public static String getId() {
        return Id;
    }


}