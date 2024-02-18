package com.example.myapplication;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import dalvik.system.PathClassLoader;

public class SwitchOgeN005 implements Testable{

    SwitchOgeN005(){}

    public Structure_Task getTask(String var, Generations generations, Context context) {
        String packageName = "com.example.myapplication";
        int min = 1;
        int max = 5;
        String r = var;
        if(r=="r"){
            r = Integer.toString(generations.RandomInt(min, max));
        }
        String activityToStart = "com.example.myapplication.Oge_5_Var_" + r;
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