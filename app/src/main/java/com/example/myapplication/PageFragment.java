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
    private final String[] label = new String[]{
            "",
            "",
            "",
            "",
            "",
            "Примеры и счёт",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
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
        if (globalVariable.isBlind()) {
            getActivity().setTheme(R.style.Theme_MyApplicationBlind);
        } else getActivity().setTheme(R.style.Theme_MyApplication);
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        TextView NumTem = result.findViewById(R.id.NumTem);
        Button button = result.findViewById(R.id.but1);
        String header = "ОГЭ №" + (pageNumber + 1) + "\n" + label[pageNumber];

        TextView estimation = result.findViewById(R.id.Estim);
        TextView attempt = result.findViewById(R.id.Attempt);

        estimation.setText("Балл: " + globalVariable.getModule("00" + (pageNumber + 1)));
        if (globalVariable.getModeAttempt())
            attempt.setText("Попыток осталось: " + globalVariable.getAttempt(pageNumber + 1));
        else
            attempt.setText("Без ограничений");


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((globalVariable.getAttempt(pageNumber + 1) > 0) || !globalVariable.getModeAttempt() ) {
                    if (globalVariable.getModeAttempt())
                        globalVariable.setAttemptMinus(pageNumber + 1);
                    String activityToStart = "com.example.myapplication.Test_Oge_" + (pageNumber + 1);
                    try {
                        Class<?> c = Class.forName(activityToStart);
                        Intent intent = new Intent(getContext(), c);
                        startActivity(intent);
                    } catch (ClassNotFoundException ignored) {
                    }
                } else {
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            "Попытки закончились", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        NumTem.setText(header);
        return result;
    }
}