package com.example.modelviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.modelviewapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyViewModel viewModel;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        //link viewmodel with the data binding

        mainBinding.setMyviewmodel(viewModel);

//        mainBinding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewModel.increaseCounter();
//            }
//        });
//        mainBinding.counter.setText(""+viewModel.getContador());
        //observir the LIVEDATA

        viewModel.getContador().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer counter) {
                //UPDATE THE UI WHEN the LiveData changes
                mainBinding.counter.setText(""+ counter);
            }
        });
    }
}