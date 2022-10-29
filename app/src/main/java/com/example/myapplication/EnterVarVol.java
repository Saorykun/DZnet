package com.example.myapplication;

import java.util.ArrayList;

public class EnterVarVol {
    private String name;
    private ArrayList<String> var;
    private ArrayList<Integer> vol;

    EnterVarVol(){}

    EnterVarVol(String name,ArrayList<String> var,ArrayList<Integer> vol){
        this.name=name;
        this.var=var;
        this.vol=vol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getVar() {
        return var;
    }

    public ArrayList<Integer> getVol() {
        return vol;
    }

    public void addVol(int a,int vol){
        if(this.vol==null)
            this.vol=new ArrayList<>();
        this.vol.add(a,vol);
    }

    public void addVar(int a,String var){
        if(this.var==null)
            this.var=new ArrayList<>();
        this.var.add(a,var);
    }
}
