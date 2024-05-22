package com.example.myapplication;

public class Oge_1_Var_1 implements Taskable {

    private final static String Id = "001";
    private Structure_Task task;

    Oge_1_Var_1() { }



    public Structure_Task getTask(Generations generations) {
        int a = generations.RandomInt(10, 50);
        int b = generations.RandomInt(51, 100);
        double avg = ((a + b) / 2.0);

        String text = String.format("Найдите среднее арифметическое между числами %d и %d.", a, b);

        Structure_Task task = new Structure_Task();
        task.setText(text);
        task.setAnswer(generations.checkAnswer(avg));
        return task;
    }



    public static String getId() {
        return Id;
    }


}