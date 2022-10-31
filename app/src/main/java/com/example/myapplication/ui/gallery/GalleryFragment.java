package com.example.myapplication.ui.gallery;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.GlobalClass;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentGalleryBinding;

import java.text.DecimalFormat;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        TableLayout tableLayout = binding.tableLayout;
        int y = 0;
        DecimalFormat df = new DecimalFormat("000");

        TableRow tableRow0 = new TableRow(getContext());
        tableRow0.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        tableRow0.setPadding(32,8,32,8);

        TextView tv10 = new TextView(getContext());
        tv10.setTextAppearance(R.style.Task);
        tv10.setPadding(8, 8, 8, 8);
        tv10.setText("");
        tableRow0.addView(tv10, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));

        TextView textView10 = new TextView(getContext());
        textView10.setTextAppearance(R.style.Task);
        textView10.setPadding(8, 8, 8, 8);
        textView10.setText("Балл");

        TextView textView20 = new TextView(getContext());
        textView20.setTextAppearance(R.style.Task);
        textView20.setPadding(8, 8, 8, 8);
        textView20.setText("Верность");

        tableRow0.addView(textView10, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));
        tableRow0.addView(textView20, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));

        tableLayout.addView(tableRow0, y);
        y++;

        for (int i = 0; i < 200; i++) {
            if (globalVariable.getVolAnswer(df.format(i + 1)) >0) {
                TableRow tableRow = new TableRow(getContext());
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tableRow.setPadding(32,8,32,8);

                TextView tv1 = new TextView(getContext());
                tv1.setTextAppearance(R.style.Task);
                tv1.setPadding(8, 8, 8, 8);
                tv1.setText("ОГЭ №" + (i + 1));
                tableRow.addView(tv1, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));

                TextView textView1 = new TextView(getContext());
                textView1.setTextAppearance(R.style.Task);
                textView1.setPadding(8, 8, 8, 8);
                textView1.setText(String.valueOf(globalVariable.getModule(df.format(i + 1))));

                TextView textView2 = new TextView(getContext());
                textView2.setTextAppearance(R.style.Task);
                textView2.setPadding(8, 8, 8, 8);
                textView2.setText(globalVariable.getRightAnswer(df.format(i + 1))*100/(globalVariable.getVolAnswer(df.format(i + 1)))+"%");

                tableRow.addView(textView1, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));
                tableRow.addView(textView2, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));

                tableLayout.addView(tableRow, y);
                y++;
            }
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}