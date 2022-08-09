package com.royalaviation.scrollp3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemReselectedListener(navListener);
        getSupportActionBar().hide();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
    }

    private NavigationBarView.OnItemReselectedListener navListener = new NavigationBarView.OnItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;

                case R.id.nav_settings:
                    selectedFragment = new SettingsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();

        }
    };
}