package com.example.sql;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.sql.database.DbOpenHelper;
import com.example.sql.model.Intern;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editName)
    EditText edtName;
    @BindView(R.id.editFname)
    EditText edtFname;
    @BindView(R.id.editAge)
    EditText edtAge;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnViewAll)
    Button btnViewAll;
    DbOpenHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myDB = new DbOpenHelper(MainActivity.this);
    }

    @OnClick({R.id.btnSave})
    public void saveData(View view) {
        boolean isInserted = myDB.saveData(edtName.getText().toString(),
                edtFname.getText().toString(),
                edtAge.getText().toString());
        if (isInserted = true) {
            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick({R.id.btnViewAll})
    public void viewAllData() {
        List<Intern> interns = myDB.getAllIntern();
        for (Intern itemIntern : interns) {
            Log.v("MainActivity", itemIntern.toString());
        }
    }
}
