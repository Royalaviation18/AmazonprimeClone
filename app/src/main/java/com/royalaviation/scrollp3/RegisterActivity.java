package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] plans = {"179/- Monthly", "459/- Quarterly", "1499/- Yearly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        Spinner spinPlan = findViewById(R.id.spinner);
        spinPlan.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, plans);

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinPlan.setAdapter(ad);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), plans[i], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}