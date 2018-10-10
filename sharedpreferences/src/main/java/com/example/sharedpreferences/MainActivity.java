package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    private static final String KEY = "Key";
    @BindView(R.id.spinnerLanguage)
    Spinner spinner;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.textVieContet)
    TextView textViewContent;
    @BindView(R.id.btnGet)
    Button btnGet;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setCountrySpiner();
    }

    void saveText() {
        sharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String selectedLanguage = spinner.getSelectedItem().toString();
        editor.putString(KEY, selectedLanguage);
        editor.apply();
        Toast.makeText(this, "Text was saved", Toast.LENGTH_SHORT).show();
    }

    void getData() {
        sharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
        String savedText = sharedPreferences.getString(KEY, "");
        textViewContent.setText(savedText);
    }

    @OnClick({R.id.btnSave})
    public void btnSave(View view) {
        saveText();
    }

    @OnClick({R.id.btnGet})
    public void btnGet(View view) {
        getData();
    }

    private void setCountrySpiner() {
        Spinner spinner = findViewById(R.id.spinnerLanguage);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
