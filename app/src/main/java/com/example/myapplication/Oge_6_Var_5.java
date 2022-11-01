package com.example.myapplication;

public class Oge_6_Var_5 implements Taskable {

    private final static String Id = "006";
    private Structure_Task task;

    Oge_6_Var_5() { }



    public Structure_Task getTask(Generations generations) {
        double a, b, c;
        int x,y,z;
        x = generations.RandomInt(0, 1);
        y = generations.RandomInt(0, 1);
        z = generations.RandomInt(0, 2);
        a = generations.RandomInt(2, 10);
        c = generations.RandomInt(2, 10);
        String[] step=new String[]{"\u00B2","\u00B3","\u2074"};
        String[] step2=new String[]{"\u2074","\u2075","\u2076"};
        String min = "\u207B";
        String text = String.format("Вычисли: (%s*%s%s)%s*(%s*%s%s)", generations.checkAnswer(a), 10, step[x],step[y],generations.checkAnswer(c),10,(min+step[z]));

        task = new Structure_Task();
        task.setText(text);
        task.setAnswer(Math.pow(a,y)*c*Math.pow(10,(x+2)*(y+2)-z-2));
        return task;
    }

    public static String getId() {
        return Id;
    }


}