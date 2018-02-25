package com.example.android.silviafirdaus_1202154345_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUsername = findViewById(R.id.inputUsername); //mengambil data dari xml
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    // proses login
    public void onLogin(View view) {
        if ( inputUsername.getText().toString().equals("EAD") &&
                inputPassword.getText().toString().equals("MOBILE") ) {
            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show(); //jika kondisi berhasil
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show(); //jika kondisi gagal
            inputUsername.setText("");
            inputPassword.setText("");
        }
    }
}
