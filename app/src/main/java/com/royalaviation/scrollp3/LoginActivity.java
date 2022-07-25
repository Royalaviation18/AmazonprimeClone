package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText etUname,etUPass;
    private Button btnSign;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        etUname = findViewById(R.id.etName);
        etUPass = findViewById(R.id.etPass);
        btnSign = findViewById(R.id.btnSign);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {
        name = etUname.getText().toString();
        pass = etUPass.getText().toString();

        if(name.isEmpty()){
            etUname.setError("Please Enter your name");
            etUname.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            etUPass.setError("Please Enter your password");
            etUPass.requestFocus();
            return;
        }
        if(!name.equals("Rohit")){
            etUname.setError("Please enter correct name");
            etUname.requestFocus();
            return;
        }
        if(!pass.equals("Rohit123")){
            etUPass.setError("Password doesn't match");
            etUPass.requestFocus();
            return;
        }

        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }
}