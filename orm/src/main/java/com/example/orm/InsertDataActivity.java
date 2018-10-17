package com.example.orm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.orm.database.Database_Helper;
import com.example.orm.model.Information_Model;
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
    private Database_Helper database_helper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.addBtn})
    public void addInfo() {
        if (addName.getText().toString().trim().length() > 0 &&
                addEmail.getText().toString().trim().length() > 0) {
            final Information_Model information_model = new Information_Model();
            information_model.name = addName.getText().toString();
            information_model.email = addEmail.getText().toString();

            try {
                final Dao<Information_Model, Integer> informationDao =
                        getHelper().getInformationDao();
                informationDao.create(information_model);
                reset();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void reset() {
        addName.setText("");
        addEmail.setText("");
    }

    private Database_Helper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this, Database_Helper.class);
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