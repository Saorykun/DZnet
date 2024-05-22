package com.example.myapplication;

public class Oge_7_Var_1 implements Taskable {

    private final static String Id = "007";
    private Structure_Task task;

    Oge_7_Var_1() { }



    public Structure_Task getTask(Generations generations) {
        double x = (double) generations.RandomInt(2, 9)/10;
        int y1 = 1;
        int y2 = generations.RandomInt(13,29);
        int y3 = generations.RandomInt(13,29);
        double i = (double) y1/y2;
        int count=0;
        while(i-x<=0.001) {
            i = i + (double) y1 / y2;
            count++;
        }
        double i2 = (double) y1/y3;
        int count2=0;
        while(i2-x<=0.001) {
            i2 = i2 + (double) y1 / y3;
            count2++;
        }
        String text = String.format("Какое десятичное число округлённое до десятых заключено между числами?: %s/%s и %s/%s", y1*count, y2, y1*(count2+1), y3);

        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(x);
        return task;
    }

    public static String getId() {
        return Id;
    }


}