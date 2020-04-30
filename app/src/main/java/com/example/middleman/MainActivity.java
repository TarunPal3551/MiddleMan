package com.example.middleman;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    final Fragment fragment1 = new DashboardFragment();
    final Fragment fragment2 = new HistoryFragment();
    final Fragment fragment3 = new AccountFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        fm.beginTransaction().add(R.id.fragment_containerLayout, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.fragment_containerLayout, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fragment_containerLayout, fragment1, "1").commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.history:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;

                case R.id.account:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;
                case R.id.dashboard:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;

            }
            return false;
        }
    };
}
