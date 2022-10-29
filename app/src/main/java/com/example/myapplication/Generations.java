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
        random = new Random(quality(seed));

        //Для улучшения качества рандома
        int x = random.nextInt(19);
        x = random.nextInt(19);
        x = random.nextInt(19);

    }

    public String getSeed() {
        return seed;
    }

    public String checkAnswer(double answer) {
        String trueAnswer=Double.toString(answer);
        int i =0;
        if(trueAnswer.length()>10){
            trueAnswer = Double.toString(answer).substring(0,Double.toString(answer).length()-3);
            String tt=trueAnswer.substring(trueAnswer.length()-1);
            if((tt.equals("0"))){
                while (trueAnswer.substring(trueAnswer.length()-1).equals("0")||trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                    if(trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                        trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);

                        return trueAnswer;
                    }
                    trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);
                }
            }
            else {
                while (trueAnswer.substring(trueAnswer.length()-1).equals("9")||trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                    if(trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                        trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);
                        while (trueAnswer.substring(trueAnswer.length()-1-i,trueAnswer.length()-i).equals("9")){
                            i++;
                        }
                        String tmp = trueAnswer.substring(trueAnswer.length()-1-i,trueAnswer.length()-i);
                        trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1-i)+(Integer.parseInt(tmp)+1);
                        for (;i>0;i--)
                            trueAnswer+=0;
                        return trueAnswer;
                    }
                    trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);
                }
                String tmp = trueAnswer.substring(trueAnswer.length()-1);
                trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1)+Integer.toString(Integer.parseInt(tmp)+1);
            }
            return trueAnswer;
        }
        else {
            String tt=trueAnswer.substring(trueAnswer.length()-1);
            if((tt.equals("0"))){
                while (trueAnswer.substring(trueAnswer.length()-1).equals("0")||trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                    if(trueAnswer.substring(trueAnswer.length()-1).equals(".")){
                        trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);

                        return trueAnswer;
                    }
                    trueAnswer=trueAnswer.substring(0,trueAnswer.length()-1);
                }
            }
            return trueAnswer;
        }
    }

    private long quality(String seed){
        long seedy=0;
        int i=0;
        while(seed.length()>=10){
            if(seed.length()<=20){
                try {
                    seedy+=Long.parseLong(seed.substring(0,10));
                }catch (Exception e){};
                seed=seed.substring(10);
            }
            else {
                try {
                    seedy+=Long.parseLong(seed.substring(0,10));
                }catch (Exception e){};
                seed=seed.substring(10);
            }
        }
        return seedy;
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
