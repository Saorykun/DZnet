package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "db.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    //Получение списка заданий которые проходил ученик
    public ArrayList<String> getTasks(){
        LocalDate currentDate = LocalDate.now();
        LocalDate modifiedDate = currentDate.minusMonths(1);

        // Создаем новый образец для классификации
        Cursor cursor = getDataByQuery("SELECT * FROM TEST_RES WHERE DATE > " + modifiedDate.toString(), null);
        ArrayList<String> tasks = new ArrayList<>();
        int columnIndex = cursor.getColumnIndex("task");

        while (cursor.moveToNext()) {
            String value = cursor.getString(columnIndex);
            if (!tasks.contains(value))
                tasks.add(value);
        }
        return tasks;
    }

    //Получение последовательности верноных/неверных решений для всех заданий
    public double[][] getSeqRightTaskMass(){
        LocalDate currentDate = LocalDate.now();
        LocalDate modifiedDate = currentDate.minusMonths(1);
        ArrayList<String> tasks = getTasks();
        List<List<Double>> DouPRList = new ArrayList<>();
        for (String number : tasks) {
            Cursor cursor1= getDataByQuery("SELECT date, GROUP_CONCAT(CAST(ver AS TEXT)) AS sequence FROM TEST_RES WHERE TASK=" + number + " and date > " + modifiedDate.toString() + " ORDER BY date LIMIT 5", null);
            String StrPR="";
            if (cursor1!= null && cursor1.moveToFirst()) {
                int sequenceIndex = cursor1.getColumnIndex("sequence");
                if (sequenceIndex != -1) {
                    StrPR = cursor1.getString(sequenceIndex);
                    // Далее обрабатываем строку StrPR
                } else {
                    // Обработка ситуации, когда столбец "sequence" не найден
                }
                cursor1.close();
            } else {
                // Обработка ситуации, когда курсор пуст или не удалось выполнить запрос
            }
            String[] numbers = StrPR.split(",");
            Double[] DouPR = new Double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                DouPR[i] = Double.parseDouble(numbers[i]);
            }
            DouPRList.add(new ArrayList<Double>(Arrays.asList(DouPR)));
            System.out.println("НОМ: " + number + " : " + StrPR + " " + Arrays.toString(DouPR));
        }
        double[][] dataToPR = new double[DouPRList.size()][];
        for (int i = 0; i < DouPRList.size(); i++) {
            List<Double> row = DouPRList.get(i);
            int len;
            if (row.size() > 5) {
                len = 5;
            }
            else {
                len = row.size();
            }
            dataToPR[i] = new double[len];
            for (int j = row.size()-len; j < row.size(); j++) {
                dataToPR[i][j-row.size()+len] = row.get(j);
            }
        }
        // Вывод результата
        for (double[] row : dataToPR) {
            for (double num1: row) {
                System.out.print(num1+ " ");
            }
            System.out.println();
        }
        return dataToPR;
    }
    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    public Cursor getDataByQuery(String query, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, selectionArgs);
        return cursor;
    }

    public void insertData(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("TEST_RES", null, values);
        db.close();
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }

    public double[][] getTestData() {
        // Ваш код для извлечения тестовых данных из базы данных или другого источника
        // Примерный формат возвращаемых данных:
        double[][] testData = {
//                {0,0,0,0,0},
//                {0,1,0,0,0},
//                {0,1,1,0,0},
//                {0,0,0,0,1},
//                {1,0,1,0,1},
//                {0,0,1,1,1},
//                {0,1,1,1,1}
                {0,0,0,1,0,1,1,1,1,0},
                {1,0,0,0,0,1,0,0,0,1},
                {1,0,1,0,1,1,0,0,0,0},
                {0,1,0,0,1,0,1,0,1,0},
                {0,0,0,0,1,1,0,0,0,1},
                {1,0,1,0,0,1,1,0,1,1},
                {1,1,0,0,1,0,0,0,0,0},
                {1,1,1,0,1,1,1,1,1,0},
                {0,1,0,0,0,1,0,1,0,1},
                {1,0,0,1,0,0,0,1,0,1},
                {1,1,0,1,1,0,0,1,1,1},
                {0,1,1,1,1,0,0,0,0,0},
                {0,1,1,1,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,0,0,0},
                {1,1,1,0,0,0,1,1,1,0},
                {0,1,1,1,1,1,0,1,1,0},

                {0,0,0,1,1,0,1,0,1,1},
                {0,0,1,0,1,1,1,1,0,1},
                {1,0,0,0,1,0,1,0,1,1},
                {1,0,1,1,1,1,0,0,1,1},
                {0,1,1,1,0,0,1,1,0,1},
                {1,0,1,0,0,1,0,0,1,0},
                {1,0,0,1,1,0,0,0,1,0},
                {0,1,0,0,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,0,1,1},
                {0,0,1,1,0,1,1,0,1,1}

        };
        return testData;
    }

    // Метод для получения правильных меток для тестовых данных
    public double[] getTrueLabels() {
        // Ваш код для извлечения меток из базы данных или другого источника
        // Примерный формат возвращаемых меток:
        double[] trueLabels = {
                1,-1,-1,-1,-1,1,-1,1,-1,-1,1,-1,-1,-1,1,1,
                1,1,1,1,1,-1,-1,1,1,1
        };
        return trueLabels;
    }
}