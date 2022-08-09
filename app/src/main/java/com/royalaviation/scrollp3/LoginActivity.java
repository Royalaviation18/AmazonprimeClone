package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUname, etUPass;
    private Button btnSign;
    private ProgressDialog pd;
    private TextView tvTerms,tvNew;
    String name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        etUname = findViewById(R.id.etName);
        etUPass = findViewById(R.id.etPass);
        btnSign = findViewById(R.id.btnSign);
        tvTerms = findViewById(R.id.textView2);
        tvNew = findViewById(R.id.tvNew);
        pd = new ProgressDialog(this);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

        tvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                terms();
            }
        });

        tvNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void terms() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/gp/help/customer/display.html/ref=ap_signin_notification_privacy_notice?ie=UTF8&nodeId=200534380"));
        startActivity(intent);
    }

    private void validate() {
        name = etUname.getText().toString();
        pass = etUPass.getText().toString();

        if (name.isEmpty()) {
            etUname.setError("Please Enter your name");
            etUname.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            etUPass.setError("Please Enter your password");
            etUPass.requestFocus();
            return;
        }
        if (!name.equals("Rohit")) {
            etUname.setError("Please enter correct name");
            etUname.requestFocus();
            return;
        }
        if (!pass.equals("Rohit123")) {
            etUPass.setError("Password doesn't match");
            etUPass.requestFocus();
            return;
        } else {
            pd.setTitle("Login Account");
            pd.setMessage("Please wait,while we are checking the login credentials");
            pd.setCanceledOnTouchOutside(false);
            pd.show();
            Intent intent = new Intent(LoginActivity.this, BotActivity.class);
            intent.putExtra("name", "Rohit");
            startActivity(intent);
        }
    }
}