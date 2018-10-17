package com.example.room_dagger.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.room_dagger.di.Injector;
import com.example.room_dagger.R;
import com.example.room_dagger.model.Intern;
import com.example.room_dagger.presenter.MainActivityPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DataView{
    @Inject
    Context applicationContext;
    @Inject
    MainActivityPresenter mainActivityPresenter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Injector.INSTANCE.initMainComponent(this);
        mainActivityPresenter.setDataView(this);
    }

    @OnClick({R.id.btnSave})
    public void saveData(View view) {
        Intern intern = new Intern();
        intern.setName(edtName.getText().toString());
        intern.setfName(edtFname.getText().toString());
        mainActivityPresenter.saveDataInRoom(intern);
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btnViewAll})
    public void viewAllData() {
        mainActivityPresenter.getAllUsers();
    }

    @OnClick({R.id.btnSearch})
    public void searchByName() {
        mainActivityPresenter.getUserByName(edtName.getText().toString());
    }

    @Override
    public void onGetAllInternsSuccesfully(List<Intern> intern) {
    dbContent.setText(String.valueOf(intern.size()));
    }

    @Override
    public void onInternGetSuccesfully(Intern intern) {
    dbContent.setText(intern.getInfo());
    }
}
