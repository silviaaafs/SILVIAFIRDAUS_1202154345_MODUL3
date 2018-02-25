package com.example.android.silviafirdaus_1202154345_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    // Inisialisasi objek
    ImageView imgLogo, imgBattery;
    TextView textTitle, textLiter;
    ImageButton btnMinus, btnPlus;

    // ada 7 level liter 0 - 6 (full)
    int liter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // mengambil intent dari activity list menu
        Intent intent = getIntent();

        imgLogo = findViewById(R.id.imageView); //mengambil data dari xml
        imgBattery = findViewById(R.id.imageBottle);
        textTitle = findViewById(R.id.textTitle);
        textLiter = findViewById(R.id.textLiter);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);

        int image = intent.getIntExtra("image", 0); //menggambungkan data dari listMenu dan xml
        imgLogo.setImageResource(image);
        textTitle.setText(intent.getStringExtra("title"));

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liter--;
                update_gambar(liter);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liter++;
                update_gambar(liter);
            }
        });
    }

    // method untuk isi air
    private void update_gambar(int liter) {
        switch (liter) {
            case 0:
                btnMinus.setEnabled(false); //karena sudah habis maka tidak bisa dikurangi lagi
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_20); //kondisi ketika button diklik maka akan mengambil gambar
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(), //ketika air kosong maka akan menampilkan toast
                        "Air Sedikit",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case 1:
                btnMinus.setEnabled(true); //
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_30);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 2:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_50);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 3:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_60);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 4:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_80);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 5:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_90);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 6:
                btnPlus.setEnabled(false);
                btnMinus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_full);
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(), //ketika air sudah penuh maka akan muncul toast
                        "Air Sudah Full",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}
