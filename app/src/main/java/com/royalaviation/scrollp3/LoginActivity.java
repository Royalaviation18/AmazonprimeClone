package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUname, etUPass;
    private Button btnSign, btnSave, btnClear, btnRetrieve;
    private ProgressDialog pd;
    private TextView tvTerms, tvNew;
    String name, pass;
    SharedPreferences sharedPreferences;

    public static final String myPref = "myPref";
    public static final String Name = "nameKey";
    public static final String Pass = "passKey";

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
        btnSave = findViewById(R.id.btnSave);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        btnClear = findViewById(R.id.btnClear);
        pd = new ProgressDialog(this);

        sharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieve();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        if (sharedPreferences.contains(Name)) {
            etUname.setText(sharedPreferences.getString(Name, ""));
        }

        if (sharedPreferences.contains(Pass)) {
            etUPass.setText(sharedPreferences.getString(Pass, ""));
        }

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
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void clear() {
        etUname = findViewById(R.id.etName);
        etUPass = findViewById(R.id.etPass);
        etUname.setText("");
        etUPass.setText("");
    }

    private void retrieve() {
        etUname = findViewById(R.id.etName);
        etUPass = findViewById(R.id.etPass);
        sharedPreferences = getSharedPreferences(myPref, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Name)) {
            etUname.setText(sharedPreferences.getString(Name, ""));
        }
        if (sharedPreferences.contains(Pass)) {
            etUPass.setText(sharedPreferences.getString(Pass, ""));
        }
    }

    private void save() {
        String name = etUname.getText().toString();
        String pass = etUPass.getText().toString().trim();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, name);
        editor.putString(Pass, pass);
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
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