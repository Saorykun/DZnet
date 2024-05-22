package com.example.myapplication;

public class Oge_2_Var_1 implements Taskable {

    private final static String Id = "002";
    private Structure_Task task;

    Oge_2_Var_1() { }



    public Structure_Task getTask(Generations generations) {
        int a = generations.RandomInt(2, 10);
        int b = generations.RandomInt(11, 50);
        int result = (b / a) * a;

        String text = String.format("Найдите наибольшее число, меньшее %d, которое кратно %d.", b, a);

        Structure_Task task = new Structure_Task();
        task.setText(text);
        task.setAnswer(result);
        return task;
    }




    public static String getId() {
        return Id;
    }


}