package com.example.orm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.addInformation)
    Button getAddInformation;
    @BindView(R.id.showInformation)
    Button showInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.addInformation})
    public void addInformationToDb() {
        startActivity(new Intent(MainActivity.this, InsertDataActivity.class));
    }

    @OnClick({R.id.showInformation})
    public void showInformation() {
        startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
    }
}