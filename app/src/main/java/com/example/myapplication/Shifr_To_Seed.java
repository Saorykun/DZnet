package com.example.myapplication;

public class Shifr_To_Seed {

    public String unity(int... num){
        String seed="";
        for(int counter=0;counter<num.length;counter++){
            if(counter!=0) {
                int length = String.valueOf(num[counter]).length();
                if (length == 1) {
                    seed = seed + "0" + num[counter];
                }
                if (length == 2) {
                    seed = seed + num[counter];
                }
                if (length > 2) {
                    while (length != 2) {
                        num[counter] /= 10;
                        length = String.valueOf(num[counter]).length();
                    }
                }
            }
            else{
                seed = seed+""+num[counter];
            }
        }
        int length = num.length;
        if (length <100) {
            if(length<10)
                seed = seed +"0"+ num.length;
            else
                seed = seed + num.length;
        } else {
            while (length > 99) {
                length /= 10;
            }
            seed = seed + num.length;
        }

        return seed;
    }

    public String[] getEnter_task(String seed){
        int n=(int)(Long.parseLong(seed)%100);
        int[] number;
        number = new int[n/2];
        seed=seed.substring(0,seed.length()-4);
        for(int i=1 ; i<n ; i+=2){
            number[i/2]=(int)(Long.parseLong(seed)%100);
            seed=seed.substring(0,seed.length()-4);
        }
        for(int i = 0; i < number.length / 2; i++)
        {
            int temp = number[i];
            number[i] = number[number.length - i - 1];
            number[number.length - i - 1] = temp;
        }
        String[] numStr=new String[number.length];
        for(int i=0;i<number.length;i++)
            numStr[i] = Integer.toString(number[i]);
        return numStr;
    }
    public int[] getVol_task(String seed){
        int n=(int)(Long.parseLong(seed)%100)-1;
        int[] number;
        number = new int[n/2];
        seed=seed.substring(0,seed.length()-2);
        for(int i=1 ; i<n ; i+=2){
            number[i/2]=(int)(Long.parseLong(seed)%100);
            seed=seed.substring(0,seed.length()-4);
        }
        for(int i = 0; i < number.length / 2; i++)
        {
            int temp = number[i];
            number[i] = number[number.length - i - 1];
            number[number.length - i - 1] = temp;
        }
        return number;
    }

}
