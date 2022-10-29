package com.example.myapplication;

import java.util.ArrayList;

public class StructureGen  {

    private ArrayList<EnterVarVol> enterVarVol;
    private String seedVol;                              //Заданный сид исключает все остальное


    StructureGen(ArrayList<EnterVarVol> enterVarVol,String seedVol){
        this.enterVarVol=enterVarVol;
        this.seedVol=seedVol;
    }

    public ArrayList<EnterVarVol> getEnterVarVol() {
        return enterVarVol;
    }

    public void setEnterVarVol(ArrayList<EnterVarVol> enter_task) {
        this.enterVarVol = enter_task;
    }

    public String getSeedVol() {
        return seedVol;
    }

    public int getSumEnter(){
        return enterVarVol.size();
    }

    public int getSumVar(int i){
        return enterVarVol.get(i).getVar().size();
    }

    public int getSumVol(int i){
        return enterVarVol.get(i).getVol().size();
    }

    public int getSumAllVol(){
        int sumVol=0;
        for(int i=0;i>enterVarVol.size();i++){
            for (int r=0;r<enterVarVol.get(i).getVol().size();r++)
                sumVol+=enterVarVol.get(i).getVol().get(r);
        }
        return sumVol;
    }

    public void setSeedVol(String seedVol) {
        this.seedVol = seedVol;
    }
}
