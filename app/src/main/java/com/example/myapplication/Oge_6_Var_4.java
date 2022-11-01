package com.example.myapplication;

public class Oge_6_Var_4 implements Taskable {

    private final static String Id = "006";
    private Structure_Task task;

    Oge_6_Var_4() { }

    public Structure_Task getTask(Generations generations) {
        double a, b, c, x;
        x = generations.RandomDouble(-5, 5, 1);
        a = generations.RandomInt(1, 10);
        c = generations.RandomInt(1, 10);
        b = c*a*x;
        String text = String.format("Вычисли: %s/(%s*%s)", generations.checkAnswer(b), generations.checkAnswer(a), generations.checkAnswer(c));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(x);
        return task;
    }

    public static String getId() {
        return Id;
    }


}