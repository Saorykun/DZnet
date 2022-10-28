package com.example.myapplication;

public class GenerateSeed {

    private String seed;

    GenerateSeed(){}

    public Generations generationSeed(String seedVol,String[] Enter_task,int[] Vol_task){
        Shifr_To_Seed shifr_to_seed = new Shifr_To_Seed();
        if(seedVol=="0"){
            Boolean flag=true;
            int k=0;
            int[] mass = new int[Enter_task.length*2+1];
            this.seed = Integer.toString((int) System.currentTimeMillis());
            for(int i=0; i<Enter_task.length*2+1;i++){
                if(i==0){
                    mass[i]=Integer.parseInt(seed);
                }
                else{
                    if(flag){
                        mass[i]=Integer.parseInt(Enter_task[k]);
                        flag=!flag;
                    }
                    else{
                        mass[i]=Vol_task[k];
                        flag=!flag;
                        k++;
                    }
                }
            }

            this.seed=shifr_to_seed.unity(mass);
        }
        else{
            Vol_task= shifr_to_seed.getVol_task(seedVol);
            Enter_task=shifr_to_seed.getEnter_task(seedVol);
            this.seed=seedVol;
        }
        Generations generations = new Generations(seed);
        return generations;
    }
}
