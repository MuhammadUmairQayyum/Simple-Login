package com.androidapp.mvvmdatabinding.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;




import android.view.View;
import android.widget.Toast;
// cccd
import com.androidapp.mvvmdatabinding.R;


import com.androidapp.mvvmdatabinding.databinding.ActivityMainBinding;
import com.androidapp.mvvmdatabinding.viewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();

    }
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
