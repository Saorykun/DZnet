package com.example.myapplication;

public class Oge_3_Var_1 implements Taskable {

    private final static String Id = "003";
    private Structure_Task task;

    Oge_3_Var_1() { }


    public Structure_Task getTask(Generations generations) {
        int a = generations.RandomInt(3, 20);
        int b = generations.RandomInt(5, 20);
        int difference = Math.abs(b * b - a * a);

        String text = String.format("Найдите разницу между квадратом числа %d и квадратом числа %d.", b, a);

        Structure_Task task = new Structure_Task();
        task.setText(text);
        task.setAnswer(difference);
        return task;
    }





    public static String getId() {
        return Id;
    }


}