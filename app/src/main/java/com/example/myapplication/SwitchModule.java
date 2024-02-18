package com.example.myapplication;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SwitchModule {

    SwitchModule() {
    }

    public Structure_Task getTask(String enter, String var, Generations generations, Context context) {
        String activityToStart = "com.example.myapplication.SwitchOgeN" + enter;
        try {
            Class<?> c = Class.forName(activityToStart);
            Class[] cArg = new Class[3];
            cArg[0]= String.class;
            cArg[1]= Generations.class;
            cArg[2]= Context.class;
            Object[] objects=new Object[3];
            objects[0]=var;
            objects[1]=generations;
            objects[2]=context;
            Method m = c.getMethod("getTask", cArg);
            m.setAccessible(true);
            Structure_Task structureTask = (Structure_Task) m.invoke(c.newInstance(),objects);
            return structureTask;
        }
        catch (NoSuchMethodException ignored) { }
        catch (IllegalAccessException e) {e.printStackTrace();}
        catch (InvocationTargetException e) {e.printStackTrace();}
        catch (ClassNotFoundException e) {e.printStackTrace();}
        catch (InstantiationException e) {e.printStackTrace();}
        SwitchOgeN006 switchOgeN006 = new SwitchOgeN006();
        Structure_Task struct = switchOgeN006.getTask(var, generations, context);
        return struct;
    }
}
