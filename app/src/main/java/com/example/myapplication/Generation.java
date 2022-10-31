package com.example.myapplication;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generation extends Application {

    private final int seed;

    Generation() {
        this(0);
    }

    Generation(int seed) {
        this.seed = seed;
    }

    public static int RandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int RandomDouble(int min, int max, int decimal) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int RandomMul(int comp) {
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 2; i <= comp; i++) {
            if (comp % i == 0) {
                a.add(i);
            }
        }
        Random random = new Random();
        int x = a.get(random.nextInt(a.size() - 1));
        return x;
    }

    public static boolean CheckZn(int x) {
        while (true) {
            if (x % 2 == 0) {
                x /= 2;
                continue;
            }
            if (x % 5 == 0) {
                x /= 5;
                continue;
            }
            return x == 1;
        }
    }
}
