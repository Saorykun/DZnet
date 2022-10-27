package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generations {

    private String seed;
    private Random random;

    Generations(){
        this("0");
    }

    Generations(String seed){
        this.seed=seed;
        random = new Random(Long.parseLong(this.seed));

        //Для улучшения качества рандома
        int x = random.nextInt(19);
        x = random.nextInt(19);
        x = random.nextInt(19);

    }

    public int RandomInt(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }

    public double RandomDouble(double min, double max, int decimal){
        return Math.round((random.nextDouble()*(max-min) + min)*Math.pow(10,decimal))/Math.pow(10,decimal);
    }

    public int RandomMul(int comp){
        List<Integer> a = new ArrayList<Integer>();
        for(int i=2;i<=comp;i++){
            if(comp%i==0) {
                a.add(i);
            }
        }
//        Random random = new Random(Long.parseLong(this.seed));
        int x = a.get(random.nextInt(a.size()-1));
        return x;
    }

    public boolean CheckZn(int x){
        while(true){
            if((x%2==0)||(x%5==0)){
                if(x%2==0) {
                    x /= 2;
                }
                if(x%5==0){
                    x/=5;
                }
            }
            else {
                if(x==1){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }

    public Boolean isInt(float num){
        if(Math.round(num*10)%10==0)
            return true;
        else
            return false;
    }
}
