package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import libsvm.*;

public class SVM {

    private ArrayList<String> modules;
    private ArrayList<String> vol_modules;
    private svm_model model;
    private double[][] predictions;

    public SVM() {
        // Инициализация модели SVM
        model = new svm_model();
    }

    public ArrayList<ArrayList<String>> getProblemTask(Context context) {
        main(context);
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        res.add(modules);
        res.add(vol_modules);
        return res;
    }

    public void main(Context context) {
        this.modules = new ArrayList<>();
        this.vol_modules = new ArrayList<>();
        SVM classifier = new SVM();
        // Создаем тренировочные данные и метки классов
        double[][] features  = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 0, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 1, 0},

                {1,0,1,0,0,1,1,0,1,0},
                {0,0,1,1,0,0,0,0,1,0},
                {0,1,0,1,1,1,0,1,0,0},
                {1,1,1,0,0,0,0,1,0,1},
                {0,1,1,1,1,0,1,1,1,0},
                {0,0,0,0,1,1,0,1,1,0},
                {1,0,0,0,1,0,0,0,1,1},
                {1,0,0,1,1,0,0,0,0,0},
                {0,0,1,1,1,0,1,1,0,0},
                {0,0,0,0,1,1,1,1,0,0}

        };

        // Метки классов для данных (1- непроблемное задание, -1- проблемное задание)
        int[] labels = {-1, 1, 1, -1, -1, 1, 1, -1, -1, -1, -1, 1, -1, 1, 1, -1, 1, 1,
        1,-1,-1,-1,1,1,-1,-1,-1,-1};

        // Обучение модели
        classifier.train(features, labels);

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        ArrayList<String> tasks = dbHelper.getTasks();
        double[][] dataToPR= dbHelper.getSeqRightTaskMass();

        for (int i = 0; i < tasks.size(); i++) {
            double prediction = classifier.predict(dataToPR[i]);
            System.out.println("Prediction: " + prediction);
            // Сравниваем предсказанную метку
            if (prediction == 1) { // Если предсказание 1, то задание не проблемное
                System.out.println("Ne problemoe");
            } else { // В противном случае, задание проблемное
                modules.add("00" + tasks.get(i));
                vol_modules.add("2");
            }
        }
            // Получаем тестовые данные из базы данных
        double[][] testData = dbHelper.getTestData();
        // Используем модель для предсказания меток для тестовых данных
        double[] predictedLabels = new double[testData.length];
        for (int i = 0; i < testData.length; i++) {
            predictedLabels[i] = classifier.predict(testData[i]);
            System.out.println("Test #"+(i+1)+" TrueLabel: " + dbHelper.getTrueLabels()[i] + " Predict: " + predictedLabels[i]);
        }
        calculateMetrics(dbHelper.getTrueLabels(), predictedLabels);

    }

    // Метод обучения SVM
    public void train(double[][] features, int[] labels) {
        svm_problem prob = new svm_problem();
        int dataCount = features.length;
        prob.y = new double[dataCount];
        prob.l = dataCount;
        prob.x = new svm_node[dataCount][];

        for (int i = 0; i < dataCount; i++) {
            prob.x[i] = new svm_node[features[i].length];
            for (int j = 0; j < features[i].length; j++) {
                svm_node node = new svm_node();
                node.index = j;
                node.value = features[i][j];
                prob.x[i][j] = node;
            }
            prob.y[i] = labels[i];
        }

        svm_parameter param = new svm_parameter();
        param.probability = 1;
        param.gamma = 0.5;
        param.nu = 0.5;
        param.C = 1;
        param.svm_type = svm_parameter.C_SVC;
        param.kernel_type = svm_parameter.LINEAR;
        param.cache_size = 20000;
        param.eps = 0.001;

        model = svm.svm_train(prob, param);
    }

    // Метод предсказания для новых данных
    public double predict(double[] features) {
        svm_node[] nodes = new svm_node[features.length];
        for (int i = 0; i < features.length; i++) {
            svm_node node = new svm_node();
            node.index = i;
            node.value = features[i];
            nodes[i] = node;
        }
        return svm.svm_predict(model, nodes);
    }


    public static void calculateMetrics(double[] trueLabels, double[] predictedLabels) {
        int truePositives = 0;
        int falsePositives = 0;
        int trueNegatives = 0;
        int falseNegatives = 0;

        for (int i = 0; i < trueLabels.length; i++) {
            if (trueLabels[i] == 1&& predictedLabels[i] == 1) {
                truePositives++;
            } else if (trueLabels[i] == 1&& predictedLabels[i] == -1) {
                falseNegatives++;
            } else if (trueLabels[i] == -1&& predictedLabels[i] == 1) {
                falsePositives++;
            } else if (trueLabels[i] == -1&& predictedLabels[i] == -1) {
                trueNegatives++;
            }
        }

        double accuracy = (double) (truePositives + trueNegatives) / trueLabels.length;
        double precision = (double) truePositives / (truePositives + falsePositives);
        double recall = (double) truePositives / (truePositives + falseNegatives);
        double f1Score = 2 * (precision * recall) / (precision + recall);

        System.out.println("Accuracy: " + accuracy);
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
        System.out.println("F1Score: " + f1Score);
    }

}

