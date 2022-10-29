package com.example.myapplication;

import java.util.ArrayList;

public class EnterVarVol {
    private String name;
    private ArrayList<Integer> var;
    private ArrayList<Integer> vol;

    EnterVarVol(){}

    EnterVarVol(String name,ArrayList<Integer> var,ArrayList<Integer> vol){
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

    public ArrayList<Integer> getVar() {
        return var;
    }

    public void setVar(ArrayList<Integer> var) {
        this.var = var;
    }

    public ArrayList<Integer> getVol() {
        return vol;
    }

    public void setVol(ArrayList<Integer> vol) {
        this.vol = vol;
    }

    public void addVol(int vol){
        this.vol.add(vol);
    }

    public void addVol(int a,int vol){
        if(this.vol==null)
            this.vol=new ArrayList<>();
        this.vol.add(a,vol);
    }

    public void addVar(int var){
        this.var.add(var);
    }

    public void addVar(int a,int var){
        this.var.add(a,var);
    }
}
