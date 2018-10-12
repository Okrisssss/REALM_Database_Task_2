package com.example.room_db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.room_db.database.AppDatabase;
import com.example.room_db.database.InternDAO;
import com.example.room_db.model.Intern;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editName)
    EditText edtName;
    @BindView(R.id.editFname)
    EditText edtFname;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnViewAll)
    Button btnViewAll;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.dbContent)
    TextView dbContent;
    AppDatabase db = MyAplication.getInstance().getAppDatabase();
    InternDAO internDAO = db.internDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSave})
    public void saveData(View view) {
        saveToDb(edtName.getText().toString(), edtFname.getText().toString());
    }

    @OnClick({R.id.btnViewAll})
    public void viewAllData() {
        viewAllInterns();
    }

    @OnClick({R.id.btnSearch})
    public void searchByName() {
        getByNme(edtName.getText().toString());
    }

    public void saveToDb(String name, String fName) {
        Intern intern = new Intern();
        intern.setName(edtName.getText().toString());
        intern.setfName(edtFname.getText().toString());
        internDAO.insert(intern);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    public void viewAllInterns() {
        List<Intern> interns = internDAO.getAll();
        for (Intern itemIntern : interns) {
            Log.v("MainActivity", itemIntern.getInfo());
        }
    }

    public void getByNme(String name) {
        Intern internByName = internDAO.getByName(name);
        dbContent.setText(internByName.getInfo());
    }
}
