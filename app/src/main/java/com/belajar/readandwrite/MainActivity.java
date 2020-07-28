package com.belajar.readandwrite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Number {

    private TextView tvNumber;
    public static final String STATE_LIST = "state_list";
    private int mCount;
    ViewModel viewModel;
//    Integer mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.getmScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvNumber.setText(String.valueOf(integer));
            }
        });
    }

    private void initViews() {
        tvNumber = findViewById(R.id.text_view_count);
        Button btnPlus = findViewById(R.id.button_increment);
        Button btnMin = findViewById(R.id.button_decrement);
        Button btnReset = findViewById(R.id.btnReset);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    @Override
    public void decrement() {
        viewModel.decrement();
//        viewModel.decrement();
//        tvNumber.setText(String.valueOf(viewModel.getmScore()));
    }

    @Override
    public void increment() {
        viewModel.increment();
//        viewModel.increment();
//        tvNumber.setText(String.valueOf(viewModel.getmScore()));
    }

    @Override
    public void reset() {
        viewModel.reset();
//        viewModel.reset();
//        tvNumber.setText(String.valueOf(viewModel.getmScore()));
    }
}