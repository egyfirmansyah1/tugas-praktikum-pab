package com.example.praktikumpabm_2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editname;
    RadioGroup cekStatus, cekGolongan;
    RadioButton radioButton, radioButton2;
    Button hitung, hapus;
    TextView nama, total, tVstatus, tVgol;
    int gajiStatus, gajiGol, totalGaji, totalGajiGOl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname =findViewById(R.id.inputName);
        nama = findViewById(R.id.outputName);
        cekStatus = findViewById(R.id.rGstatus);
        tVstatus = findViewById(R.id.outputStatus);
        cekGolongan = findViewById(R.id.rGgolongan);
        tVgol = findViewById(R.id.outputGolongan);

        Button buttonClick = findViewById(R.id.btnHitung);
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmit(v);
                prosesHitung(v);
            }
        });
        Button buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editname.setText("");
                cekStatus.setTag(0);
                cekGolongan.setTag(0);
                nama.setText("");
                tVstatus.setText("");
                tVgol.setText("");
                total.setText("");
            }
        });
    }

    public void prosesHitung(View view){
        cekStatus = (RadioGroup)findViewById(R.id.rGstatus);
        int stt = cekStatus.getCheckedRadioButtonId();
        if(stt == R.id.rBstatus1){
            gajiStatus = 1000000;
        }else if(stt == R.id.rBstatus2){
            gajiStatus = 2000000;
        }
        cekGolongan = (RadioGroup)findViewById(R.id.rGgolongan);
        int gol = cekGolongan.getCheckedRadioButtonId();
        if(gol == R.id.rBgolongan1){
            gajiGol = 3000000;
        }else if(gol == R.id.rBgolongan2){
            gajiGol = 5000000;
        }
        totalGaji = gajiStatus + gajiGol;
        total = (TextView)findViewById(R.id.outputGaji);
        total.setText(String.valueOf(totalGaji));
    }

    public void btnSubmit(View view){
        nama.setText(editname.getText().toString());
        int radioID = cekStatus.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
        tVstatus.setText(radioButton.getText());

        int radioID2 = cekGolongan.getCheckedRadioButtonId();
        radioButton = findViewById(radioID2);
        tVgol.setText(radioButton.getText());
    }
}