package com.example.myapplication.ui.gallery;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.GlobalClass;
import com.example.myapplication.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        int BOOKSHELF_ROWS = globalVariable.amtModule();
        int BOOKSHELF_COLUMNS = 2;

        TableLayout tableLayout = binding.tableLayout;
        int y=0;
        for (int i = 0; i < 20; i++) {

            if ((globalVariable.getModule(i + 1)==2)||
                    (globalVariable.getModule(i + 1)==3)||
                    (globalVariable.getModule(i + 1)==4)||
                    (globalVariable.getModule(i + 1)==5)) {
                TableRow tableRow = new TableRow(getContext());
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                TextView textView = new TextView(getContext());
                textView.setTextSize(24f);
                textView.setTextColor(Color.argb(255, 0, 0, 0));
                textView.setPadding(40, 0, 0, 0);
                textView.setText("Тема " + (i + 1));
                tableRow.addView(textView, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.5f));
                TextView textView1 = new TextView(getContext());
                textView1.setTextSize(24f);
                textView1.setTextColor(Color.argb(255, 0, 0, 0));
                textView1.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                textView1.setPadding(0, 0, 40, 0);
                textView1.setText(String.valueOf(globalVariable.getModule(i + 1)));

                tableRow.addView(textView1, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.6f));
                //}

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