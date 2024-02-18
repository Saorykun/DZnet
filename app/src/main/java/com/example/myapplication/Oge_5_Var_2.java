package com.example.myapplication;

public class Oge_5_Var_2 implements Taskable {

    private final static String Id = "005";
    private Structure_Task task;

    public Structure_Task getTask(Generations generation) {
        int x, y, z;
        double answer;

        x = Generation.RandomInt(2, 15);
        y = Generation.RandomInt(3, 10);
        z = Generation.RandomInt(2, 5);

        answer = x * y * z;

        String text = String.format("Ученик собирается сделать стенд на конференцию. Он использует %s кусков ткани длиной %s метров каждый и %s банок краски. Сколько всего метров ткани ему нужно для этого стенда?", generation.checkAnswer(x), generation.checkAnswer(y), generation.checkAnswer(z));
        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(answer);
        return task;

    }

    public static String getId() {
        return Id;
    }


}