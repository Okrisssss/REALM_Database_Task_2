package apple.example.com.realm_database_task_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import apple.example.com.realm_database_task_2.model.Intern;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName;
    EditText edtFname;
    EditText edtAge;
    EditText edtStream;
    EditText edtHobby;
    Button btnSave;
    TextView dbContent;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtFname = findViewById(R.id.edtFname);
        edtAge = findViewById(R.id.edtAge);
        edtStream = findViewById(R.id.edtStream);
        edtHobby = findViewById(R.id.edtHobby);
        btnSave = findViewById(R.id.btnSave);
        dbContent = findViewById(R.id.dbContent);
        realm = Realm.getDefaultInstance();
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        writeToDB(edtName.getText().toString().trim(),
                edtFname.getText().toString().trim(),
                Integer.parseInt(edtAge.getText().toString().trim()),
                edtStream.getText().toString().trim(),
                edtHobby.getText().toString().trim());
        showDbContent();
    }

    public  void showDbContent(){
        RealmResults<Intern> personRealmResult = realm.where(Intern.class).findAll();
        String op = "";
        for (Intern guest : personRealmResult){
        op+=guest.toString();
        }
        dbContent.setText(op);
    }

    public void writeToDB(final String name, final String fname, final Integer age, final String stream, final String hobby) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override public void execute(Realm realm) {
                Intern user = realm.createObject(Intern.class);
                user.setName(name);
                user.setFname(fname);
                user.setAge(age);
                user.setStream(stream);
                user.setHobby(hobby);
                }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.v("Database", "Data inserted");
                }
                }, new Realm.Transaction.OnError(){
            @Override
            public void onError(Throwable error) {
                Log.v("Database", error.getMessage().toString());
            }
            }
        );
    }
}
