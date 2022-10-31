package com.example.myapplication;

public class Oge_6_Var_3 implements Taskable {

    private final static String Id = "006";
    private Structure_Task task;

    Oge_6_Var_3() { }

    public Structure_Task getTask(Generations generations) {
        double a, b, c, x;
        x = generations.RandomDouble(-5, 5, 1);
        a = generations.RandomDouble(0, 5, 1);
        c = generations.RandomDouble(0, 5, 2);
        b = x*a + c;
        String text = String.format("Вычисли: %s*%s+%s", generations.checkAnswer(x), generations.checkAnswer(a), generations.checkAnswer(c));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(b);
        return task;
    }

    public static String getId() {
        return Id;
    }


}