package com.example.myapplication;

public class Oge_4_Var_1 implements Taskable {

    private final static String Id = "004";
    private Structure_Task task;

    Oge_4_Var_1() { }

    public Structure_Task getTask(Generations generations) {
        int a = generations.RandomInt(1, 10);
        int b = generations.RandomInt(-20, 20);
        int c = generations.RandomInt(-10, 10);
        while (c==0 || b==0){
            c = generations.RandomInt(-10, 10);
            b = generations.RandomInt(-20, 20);
        }
        int discriminant = b * b - 4 * a * c;

        String text = String.format("Найдите дискриминант квадратного уравнения:\n %dx\u00B2 %+dx %+d = 0.", a, b, c);

        Structure_Task task = new Structure_Task();
        task.setText(text);
        task.setAnswer(discriminant);
        return task;
    }



    public static String getId() {
        return Id;
    }


}