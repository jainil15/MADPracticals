package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Practical5 extends AppCompatActivity {
    private Button showDialogBox;
    String[] items;
    boolean[] checkedItems;
    String selectedItems;
    TextView selectedItemsTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical4);

        showDialogBox = (Button) findViewById(R.id.show_dialog_box);
        selectedItemsTextView = (TextView) findViewById(R.id.selected_items_text_view);
        items = getResources().getStringArray(R.array.dialog_items);

        checkedItems = new boolean[items.length];
        showDialogBox.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Items");

            builder.setMultiChoiceItems(items, checkedItems, (dialogInterface, i, b) -> {
                checkedItems[i] = b;
            });

            builder.setPositiveButton("OK", (dialogInterface, i) -> {
                selectedItems = "";
                for (int j = 0; j < items.length; j++) {
                    if (checkedItems[j]) {
                        selectedItems += items[j] + ", ";
                    }
                }

                selectedItemsTextView.setText(selectedItems.substring(0, selectedItems.length() - 2));

            });
            builder.create().show();
        });

    }
}
