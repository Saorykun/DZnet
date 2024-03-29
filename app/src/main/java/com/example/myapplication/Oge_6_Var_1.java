package com.example.myapplication;

public class Oge_6_Var_1 implements Taskable {

    private final static String Id = "006";
    private Structure_Task task;

    Oge_6_Var_1() {}

    public Structure_Task getTask(Generations generation) {
        double a, b, c, x;
        x = generation.RandomDouble(1, 10, 1);
        a = generation.RandomDouble(1, 5, 1);
        c = generation.RandomDouble(1, 10, 2);
        b = a * x + c;
        String text = String.format("Вычисли: (%s-%s)/%s", generation.checkAnswer(b), generation.checkAnswer(c), generation.checkAnswer(a));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(x);
        return task;
    }

    public static String getId() {
        return Id;
    }


}