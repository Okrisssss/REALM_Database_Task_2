package com.example.orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.orm.database.DatabaseHelper;
import com.example.orm.model.InfoModel;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsertDataActivity extends AppCompatActivity {
    @BindView(R.id.addName)
    EditText addName;
    @BindView(R.id.addEmail)
    EditText addEmail;
    @BindView(R.id.addBtn)
    Button addBtn;
    private DatabaseHelper database_helper = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.addBtn})
    public void addData(){
        if(addName.getText().toString().trim().length() > 0 &&
                addEmail.getText().toString().trim().length() > 0){
            final InfoModel information_model = new InfoModel();
            information_model.name = addName.getText().toString();
            information_model.email = addEmail.getText().toString();
            try {
                final Dao<InfoModel, Integer> informationDao =
                        getHelper().getInformationDao();
                informationDao.create(information_model);
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private DatabaseHelper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return database_helper;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (database_helper != null) {
            OpenHelperManager.releaseHelper();
            database_helper = null;
        }
    }
}