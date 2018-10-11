package apple.example.com.realm_database_task_2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import apple.example.com.realm_database_task_2.database.RealmController;
import apple.example.com.realm_database_task_2.model.Intern;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtFname)
    EditText edtFname;
    @BindView(R.id.edtAge)
    EditText edtAge;
    @BindView(R.id.edtStream)
    EditText edtStream;
    @BindView(R.id.edtHobby)
    EditText edtHobby;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.btnClear)
    Button btnClear;
    @BindView(R.id.btnShow)
    Button btnShow;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.dbContent)
    TextView dbContent;
    @BindView(R.id.searchView)
    TextView searchEditText;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        realm = RealmController.with(this).getRealm();
    }

    @OnClick({R.id.btnSave})
    public void btnSave(View view) {
        writeToDB(edtName.getText().toString().trim(),
                edtFname.getText().toString().trim(),
                Integer.parseInt(edtAge.getText().toString().trim()),
                edtStream.getText().toString().trim(),
                edtHobby.getText().toString().trim());
    }
    @OnClick({R.id.btnClear})
    public void btnClear(View view) {
        clearDb();
    }
    @OnClick({R.id.btnShow})
    public void btnShow(View view) {
        showDbContent();
    }
    @OnClick({R.id.btnSearch})
    public void btnSearch(View view) {
        Intern searchedIntern = getIntern(searchEditText.getText().toString());
        if (searchedIntern == null){
            Toast.makeText(this, "No intern with such name, please try again!", Toast.LENGTH_SHORT).show();
        } else
        dbContent.setText(searchedIntern.getString());
    }

    public void showDbContent() {
        RealmResults<Intern> personRealmResult = realm.where(Intern.class).findAll();
        String content = "";
        for (Intern intern : personRealmResult) {
            content += intern.getString();
        }
        dbContent.setText(content);
    }

    public void writeToDB(final String name, final String fname, final Integer age, final String stream, final String hobby) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
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
                Toast.makeText(MainActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();
                }
                }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
            }
        );
    }

    public void clearDb() {
        final RealmResults<Intern> clearRealmResult = realm.where(Intern.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                clearRealmResult.deleteAllFromRealm();
            }
        });
    }

    public Intern getIntern(String name) {
        return realm.where(Intern.class).equalTo("name", name).findFirst();
    }
}
