package com.example.orm_lite_db;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orm_lite_db.model.DatabaseHelper;
import com.example.orm_lite_db.model.Goal;
import com.example.orm_lite_db.model.HelperFactory;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editName)
    EditText edtName;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnViewAll)
    Button btnViewAll;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.dbContent)
    TextView dbContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSave})
    public void saveData(View view) {
        try {
            saveGoal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveGoal() throws java.sql.SQLException{
    Goal g = new Goal();
    g.setName(edtName.getText().toString());
        HelperFactory.getHelper(this).getGoalDao().create(g);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }
}
