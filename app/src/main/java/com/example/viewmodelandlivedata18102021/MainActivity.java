package com.example.viewmodelandlivedata18102021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEdt;
    Button mBtnGetText;
    TextView mTv;
    MainViewModel mMainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("BBB","onCreate");

        mEdt = findViewById(R.id.edittext);
        mBtnGetText = findViewById(R.id.button);
        mTv = findViewById(R.id.textView);

        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mMainViewModel.getString().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTv.setText(s);
            }
        });

        mBtnGetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEdt.getText().toString();

                if (!text.isEmpty()){
                    mMainViewModel.setString(text);
                }
            }
        });
    }
}