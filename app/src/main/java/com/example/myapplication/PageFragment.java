package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {

    private int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        if(globalVariable.isBlind()) {
            getActivity().setTheme(R.style.Theme_MyApplicationBlind);
        }
        else getActivity().setTheme(R.style.Theme_MyApplication);
        View result=inflater.inflate(R.layout.fragment_page, container, false);

        TextView NumTem = result.findViewById(R.id.NumTem);
        Button button = result.findViewById(R.id.but1);
        String header = "Тема " + (pageNumber+1);
        switch (pageNumber){
            case(0):
                header = "Тема " + (pageNumber+1)+"\n" + "Простой счет обыкновенных дробей";
                break;
            case(1):
                header = "Тема " + (pageNumber+1)+"\n" + "Проценты";
                break;
            case(2):
                header = "Тема " + (pageNumber+1)+"\n" + "ОГЭ №1-5 Шины";
                break;
            case(3):
                header = "Тема " + (pageNumber+1)+"\n" + "ОГЭ №10 Вероятности";
                break;
            case(4):
                header = "Тема " + (pageNumber+1)+"\n" + "ЕГЭ №6 Простейшие текстовые задачи";
                break;
            case(5):
                header = "Тема " + (pageNumber+1)+"\n" + "ЕГЭ №10 Прикладная геометрия";
                break;
            case(6):
                header = "Тема " + (pageNumber+1)+"\n" + "ЕГЭ №20 Текстовые задачи";
                break;
            case(7):
                header = "Тема " + (pageNumber+1)+"\n" + "Функции";
                break;
            case(8):
                header = "Тема " + (pageNumber+1)+"\n" + "Преобразование выражений";
                break;
            case(9):
                header = "Тема " + (pageNumber+1)+"\n" + "ЕГЭ №21 Задачи на смекалку";
                break;
        }
        TextView estimation = result.findViewById(R.id.Estim);
        TextView attempt = result.findViewById(R.id.Attempt);

        estimation.setText("Балл: " + globalVariable.getModule(Integer.toString(pageNumber + 1))) ;
        if(globalVariable.getModeAttempt()){
            attempt.setText("Попыток осталось: " + globalVariable.getAttempt(pageNumber+1));
        }
        else {
            attempt.setText("Без ограничений");
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (pageNumber){
                    case (0):{
                        if(globalVariable.getAttempt(pageNumber+1)>0) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), Test_Oge_6.class);                              //ytpf,elm gjvtyznm
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (1):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema2.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (2):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema3.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (3):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema4.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (4):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema5.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (5):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema6.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (6):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema7.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (7):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema8.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (8):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema9.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                    case (9):{
                        if(globalVariable.getAttempt(pageNumber+1)<3) {
                            if(globalVariable.getModeAttempt())
                                globalVariable.setAttemptMinus(pageNumber + 1);
                            Intent i;
                            i = new Intent(getContext(), tema10.class);
                            startActivity(i);
                        }
                        else {
                            Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                                    "Попытки закончились", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        break;
                    }
                }
            }
        });
        NumTem.setText(header);
        return result;
    }
}