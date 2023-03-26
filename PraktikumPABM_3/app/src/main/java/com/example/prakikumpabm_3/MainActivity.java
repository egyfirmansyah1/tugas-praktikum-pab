package com.example.prakikumpabm_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText listview;
    AutoCompleteTextView active;
    String [] list = {
      "Fakultas Ilmu Komputer", "Fakultas Ekonomi", "Fakultas Hukum",
      "Fakultas Keutanan", "Fakultas Keguruan dan Ilmu Pendidikan"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        active = (AutoCompleteTextView) findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, list);

        active.setThreshold(1); // pemanggilan awal pertama
        active.setAdapter(adapter);
    }
    public void pilihfakultas(View v){
        listview = (EditText) findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Universitas Kuningan");
        builder.setItems(list, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item){
            listview.setText(list[item]);
            dialog.dismiss();
        }
        }).show();
    }

}