package com.example.momentsjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.momentsjava.ui.list.ListFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        if (saveInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_fragment, new ListFragment())
                    .commit();
        }
    }
}