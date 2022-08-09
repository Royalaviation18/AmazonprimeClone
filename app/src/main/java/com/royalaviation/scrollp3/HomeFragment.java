package com.royalaviation.scrollp3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private TextView tvUname;
    private ImageButton imB1, imB2, imB3, imB4;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUname = getView().findViewById(R.id.tvUname);
        imB1 = getView().findViewById(R.id.ibMv1);
        imB2 = getView().findViewById(R.id.ibMv2);
        imB3 = getView().findViewById(R.id.ibMv3);
        imB4 = getView().findViewById(R.id.ibMv4);
        //hiding the action bar
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra("name");
        tvUname.setText("Hello, " + name + "!");
        Log.d("lifecycle", "onCreate invoked");
        imB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        imB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

        imB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });
        imB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), PrimeActivity.class);
                startActivity(intent1);
            }
        });

    }
}
