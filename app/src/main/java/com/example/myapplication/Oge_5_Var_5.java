package com.example.myapplication;

public class Oge_5_Var_5 implements Taskable {

    private final static String Id = "005";
    private Structure_Task task;

    public Structure_Task getTask(Generations generation) {
        int side1, side2, side3;
        int perimeter;
        side1 = Generation.RandomInt(3, 10);
        side2 = Generation.RandomInt(3, 10);
        side3 = Generation.RandomInt(3, 10);
        perimeter = side1 + side2 + side3;
        String text = String.format("У вас есть треугольник со сторонами %s см, %s см и %s см. Найдите периметр этого треугольника.", generation.checkAnswer(side1), generation.checkAnswer(side2), generation.checkAnswer(side3));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(perimeter);
        return task;
    }

    public static String getId() {
        return Id;
    }
}
