package com.example.myapplication;

import java.util.ArrayList;

public class GenerateSeed {

    private String seed;
    private ShifrToSeed shifrToSeed;
    private StructureGen structureGen;

    GenerateSeed(){}

    public Generations generationSeed(StructureGen structureGen){
        this.structureGen = structureGen;
        this.seed=structureGen.getSeedVol();
        this.shifrToSeed = new ShifrToSeed(structureGen.getEnterVarVol());
        if(structureGen.getSeedVol()==""){
            Boolean flag=true;
            ArrayList<String> mass = new ArrayList<>();
            this.seed = Integer.toString((int) System.currentTimeMillis());
            mass.add(seed);
            int i=0;
            for (int ent=0;ent<structureGen.getSumEnter();ent++,i++){
                int tmp=0;
                for(int numName=0;numName<structureGen.getSumEnter();numName++) {
                    for (int r = 0; r < structureGen.getSumVar(numName); r++) {
                        if (structureGen.getEnterVarVol().get(numName).getVar().get(r).length() >= 2) {
                            mass.add(structureGen.getEnterVarVol().get(numName).getVar().get(r));
                        } else {
                            mass.add( "0" + structureGen.getEnterVarVol().get(numName).getVar().get(r));
                        }
                        i++;
                        tmp++;
                    }
                }
                for(int numName=0;numName<structureGen.getSumEnter();numName++) {
                    for (int r = 0; r < structureGen.getSumVol(numName); r++) {
                        if(structureGen.getEnterVarVol().get(numName).getVol().get(r)>=10){
                            mass.add(Integer.toString(structureGen.getEnterVarVol().get(numName).getVol().get(r)));
                        }
                        else {
                            mass.add("0"+structureGen.getEnterVarVol().get(numName).getVol().get(r));
                        }
                        i++;
                        tmp++;
                    }
                }
                if(tmp>=10)
                    mass.add(Integer.toString(tmp));
                else
                    mass.add("0"+tmp);

                i++;

                if((structureGen.getEnterVarVol().get(ent).getName()).length()==3){
                    mass.add(structureGen.getEnterVarVol().get(ent).getName());
                }
                else {
                    if((structureGen.getEnterVarVol().get(ent).getName()).length()==2){
                        mass.add("0"+structureGen.getEnterVarVol().get(ent).getName());
                    }
                    else {
                        mass.add("00"+structureGen.getEnterVarVol().get(ent).getName());
                    }
                    if ((structureGen.getEnterVarVol().get(ent).getName()).length()>3){
                        mass.add(""+structureGen.getEnterVarVol().get(ent).getName().substring(0,3));
                    }
                }
            }

            if(structureGen.getSumEnter()>=10)
                mass.add(Integer.toString(structureGen.getSumEnter()));
            else
                mass.add("0"+structureGen.getSumEnter());

            this.seed=shifrToSeed.unity(mass);
        }
        else{

            structureGen.setEnterVarVol(shifrToSeed.getEnterVarVol(seed));
            this.seed=structureGen.getSeedVol();
        }
        Generations generations = new Generations(seed);
        return generations;
    }

//    public StructureGen getStructureGen(){
//        this.structureGen.setVol_task(shifrToSeed.getVol_task(structureGen.getSeedVol()));
//        this.structureGen.setEnter_task(shifrToSeed.getEnter_task(structureGen.getSeedVol()));
//
//        return structureGen;
//    }
}
