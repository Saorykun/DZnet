package com.example.myapplication;

import java.util.ArrayList;

public class ShifrToSeed {

    private ArrayList<EnterVarVol> enterVarVols;

    ShifrToSeed(ArrayList<EnterVarVol> enterVarVols){
        this.enterVarVols=enterVarVols;
    }

    public String unity(ArrayList<String> num){
        String seed="";
        for(int i=0;i<num.size();i++){
            seed+=num.get(i);
        }
        return seed;
    }

    public ArrayList<EnterVarVol> getEnterVarVol(String seed){
        upload(seed);
        return this.enterVarVols;
    }


    private void upload(String seed){
        this.enterVarVols = new ArrayList<>();
        int n=Integer.parseInt(seed.substring(seed.length()-2));
        seed=seed.substring(0,seed.length()-2);

        for(int i=0;i<n;i++){                                                             //по колву энтеров
            this.enterVarVols.add(0,new EnterVarVol());
            this.enterVarVols.get(0).setName(seed.substring(seed.length()-2));            //считали энтер
            seed=seed.substring(0,seed.length()-2);
            int var=Integer.parseInt(seed.substring(seed.length()-2));
            seed=seed.substring(0,seed.length()-2);

            for(int v=0;v<var/2;v++){
                this.enterVarVols.get(0).addVol(0, Integer.parseInt(seed.substring(seed.length()-2)));
                seed=seed.substring(0,seed.length()-2);
            }
            for(int v=0;v<var/2;v++){
                this.enterVarVols.get(0).addVar(0,Integer.parseInt(seed.substring(seed.length()-2)));
                seed=seed.substring(0,seed.length()-2);
            }
        }
    }

}
