package com.example.myapplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SwitchOgeN006 implements Testable{

    SwitchOgeN006(){}

    public Structure_Task getTask(String var, Generations generations) {
        int min = 1;
        int max = 3;
        String r = var;
        if(r=="r"){
            r = Integer.toString(generations.RandomInt(min, max));
        }
        String activityToStart = "com.example.myapplication.Oge_6_Var_" + r;
        try {
            Class<?> c = Class.forName(activityToStart);
            Method m = c.getMethod("getTask", Generations.class);
            m.setAccessible(true);
            Structure_Task structureTask = (Structure_Task) m.invoke(c.newInstance(),generations);
            return structureTask;
        }
        catch (NoSuchMethodException ignored) { }
        catch (IllegalAccessException e) {e.printStackTrace();}
        catch (InvocationTargetException e) {e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}
        catch (InstantiationException e) {e.printStackTrace();}
        return null;
    }
}
