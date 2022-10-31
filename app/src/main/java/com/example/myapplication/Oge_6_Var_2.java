package com.example.myapplication;

public class Oge_6_Var_2 implements Taskable {

    private final static String Id = "006";
    private Structure_Task task;

    Oge_6_Var_2() { }

    public Structure_Task getTask(Generations generations) {
        double a, b, c, x;
        x = generations.RandomDouble(0, 5, 1);
        a = 10;
        c = generations.RandomInt(1, 99);
        b = -x * 1000 + c;
        String text = String.format("Вычисли: %s*(-%s)\u00B3+%s", generations.checkAnswer(x), generations.checkAnswer(a), generations.checkAnswer(c));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(b);
        return task;
    }

    public static String getId() {
        return Id;
    }


}