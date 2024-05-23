package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class BeautifulButton extends AppCompatButton {

    public BeautifulButton(Context context) {
        super(context);
        init(context);
    }


    private void init(Context context) {
        // Установка стиля
        setStyle(context, R.drawable.button_gradiant_1); // Используйте свой ресурс для фона кнопки
        setText(context.getString(R.string.go));
        setTextSize(16);
        setTypeface(null, Typeface.BOLD);

        // Установка белого цвета текста
        setTextColor(ContextCompat.getColor(context, android.R.color.white));

        // Установка внутренних отступов для увеличения расстояния между текстом и границами кнопки
        int padding = (int) (16 * getResources().getDisplayMetrics().density); // Пример: 16dp
        setPadding(padding, padding, padding, padding);

        // Установка размеров и отступов
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        // Установка идентификатора, если необходимо
        setId(View.generateViewId());

        // Добавление кнопки на родительский Layout с помощью ConstraintLayout.LayoutParams, если необходимо
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
        params.setMargins(16, 8, 16, 24);
        setLayoutParams(params);

        // Установка изображения слева от текста
        Drawable img = resizeImage(context, R.drawable.check, 32, 32); // Замените на свой ресурс и нужный размер
        setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
        setCompoundDrawablePadding((int) (8 * getResources().getDisplayMetrics().density)); // Пример: 8dp отступ между текстом и изображением
    }

    private void setStyle(Context context, int styleResId) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            setBackgroundResource(styleResId);
        } else {
            setBackground(ContextCompat.getDrawable(context, styleResId));
        }
    }
    private Drawable resizeImage(Context context, int resId, int widthDp, int heightDp) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int widthPx = (int) (widthDp * metrics.density);
        int heightPx = (int) (heightDp * metrics.density);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, widthPx, heightPx, true);
        return new BitmapDrawable(context.getResources(), resizedBitmap);
    }

}