package com.example.myapplication.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;

import com.example.myapplication.DatabaseHelper;

import org.w3c.dom.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classificator {

    private ArrayList<String> modules;
    private ArrayList<String> vol_modules;

    public ArrayList<ArrayList<String>> getProblemTask(Context context) {
        main(context);
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        res.add(modules);
        res.add(vol_modules);
        return res;
    }

    public Classificator() {

    }


    public void main(Context context) {
        modules = new ArrayList<>();
        vol_modules = new ArrayList<>();
        // Создаем тренировочные данные и метки классов
        List<double[]> trainingData = new ArrayList<>();
        trainingData.add(new double[]{5.0, 1.0});
        trainingData.add(new double[]{10.0, 3.0});
        trainingData.add(new double[]{2.0, 0.0});
        trainingData.add(new double[]{3.0, 1.0});
        trainingData.add(new double[]{0.0, 5.0});
        trainingData.add(new double[]{1.0, 3.0});
        trainingData.add(new double[]{2.0, 5.0});
        trainingData.add(new double[]{3.0, 7.0});

        List<String> trainingLabels = new ArrayList<>();
        trainingLabels.add("Класс A");
        trainingLabels.add("Класс A");
        trainingLabels.add("Класс A");
        trainingLabels.add("Класс A");
        trainingLabels.add("Класс B");
        trainingLabels.add("Класс B");
        trainingLabels.add("Класс B");
        trainingLabels.add("Класс B");

        // Создаем экземпляр классификатора и обучаем его на тренировочных данных
        KNearestNeighborsClassifier classifier = new KNearestNeighborsClassifier(3);
        classifier.fit(trainingData, trainingLabels);

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        LocalDate currentDate = LocalDate.now();
        LocalDate modifiedDate = currentDate.minusMonths(1);
        // Создаем новый образец для классификации
        Cursor cursor = dbHelper.getDataByQuery("SELECT * FROM TEST_RES WHERE DATE > "+modifiedDate.toString(),null);
        ArrayList<String> tasks = new ArrayList<>();



        int columnIndex = cursor.getColumnIndex("task"); // Замените "columnName" на имя вашего столбца

        while (cursor.moveToNext()) {
            String value = cursor.getString(columnIndex);
            if(!tasks.contains(value))
                tasks.add(value);
        }


        //double[] sample = new double[]{2.5, 3.5};
        List<double[]> sample = new ArrayList<>();
        for (String number : tasks) {
            sample.add(new double[]{dbHelper.getDataByQuery("SELECT * FROM TEST_RES WHERE TASK="+String.valueOf(Integer.parseInt(number))+" and DATE > "+modifiedDate.toString()+" and VER=1",null).getCount(),
                                    dbHelper.getDataByQuery("SELECT * FROM TEST_RES WHERE TASK="+String.valueOf(Integer.parseInt(number))+" and DATE > "+modifiedDate.toString()+" and VER=0",null).getCount()});
        }

        // Предсказываем метку класса для нового образца
        for (int i =0; i<sample.size();i++) {
            String predictedLabel = classifier.predict(sample.get(i));
            System.out.println("Предсказанная метка класса: " + predictedLabel);
            if(predictedLabel=="Класс B") {
                modules.add("00" + tasks.get(i));
                vol_modules.add("2");
            }
        }



    }




    public static class KNearestNeighborsClassifier {
        private List<double[]> trainingData;
        private List<String> trainingLabels;
        private int k;

        public KNearestNeighborsClassifier(int k) {
            this.k = k;
            trainingData = new ArrayList<>();
            trainingLabels = new ArrayList<>();
        }

        public void fit(List<double[]> data, List<String> labels) {
            trainingData = data;
            trainingLabels = labels;
        }

        public String predict(double[] sample) {
            List<Neighbor> neighbors = new ArrayList<>();

            // Calculate distances to all training samples
            for (int i = 0; i < trainingData.size(); i++) {
                double[] trainingSample = trainingData.get(i);
                double distance = calculateDistance(sample, trainingSample);
                neighbors.add(new Neighbor(distance, trainingLabels.get(i)));
            }

            // Sort neighbors by distance
            neighbors.sort((n1, n2) -> Double.compare(n1.distance, n2.distance));

            // Count the class occurrences among the k nearest neighbors
            Map<String, Integer> classCounts = new HashMap<>();
            for (int i = 0; i < k; i++) {
                Neighbor neighbor = neighbors.get(i);
                classCounts.put(neighbor.label, classCounts.getOrDefault(neighbor.label, 0) + 1);
            }

            // Find the class with the highest occurrence
            String predictedLabel = "";
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : classCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    predictedLabel = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            return predictedLabel;
        }

        private double calculateDistance(double[] sample1, double[] sample2) {
            double distance = 0.0;
            for (int i = 0; i < sample1.length; i++) {
                distance += Math.pow(sample1[i] - sample2[i], 2);
            }
            return Math.sqrt(distance);
        }

        private static class Neighbor {
            private double distance;
            private String label;

            public Neighbor(double distance, String label) {
                this.distance = distance;
                this.label = label;
            }
        }
    }

}






