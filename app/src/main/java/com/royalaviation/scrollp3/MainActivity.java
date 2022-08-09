package com.royalaviation.scrollp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvUname;
    private ImageButton imB1, imB2, imB3, imB4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUname = findViewById(R.id.tvUname);
        imB1 = findViewById(R.id.ibMv1);
        imB2 = findViewById(R.id.ibMv2);
        imB3 = findViewById(R.id.ibMv3);
        imB4 = findViewById(R.id.ibMv4);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvUname.setText("Hello, " + name + "!");
        Log.d("lifecycle", "onCreate invoked");
        imB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        imB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        imB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PrimeActivity.class);
                startActivity(intent1);
            }
        });
        imB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
        Toast.makeText(this, "Onstart Invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
        Toast.makeText(MainActivity.this, "OnResume Invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
        Toast.makeText(MainActivity.this, "OnPause Invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
        Toast.makeText(this, "Onstop Invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
        Toast.makeText(this, "OnRestart Invoked", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
        Toast.makeText(this, "OnDestroy Invoked", Toast.LENGTH_SHORT).show();
    }

}