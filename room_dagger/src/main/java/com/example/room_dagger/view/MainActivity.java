package com.example.room_dagger.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.room_dagger.Injector;
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
        Injector.INSTANCE.getMainComponent().inject(this);
    }

    @OnClick({R.id.btnSave})
    public void saveData(View view) {
    }

    @OnClick({R.id.btnViewAll})
    public void viewAllData() {
    }

    @OnClick({R.id.btnSearch})
    public void searchByName() {
    }

    @Override
    public void onGetAllInternsSuccesfully(List<Intern> intern) {

    }

    @Override
    public void onInternGetSuccesfully(Intern intern) {

    }

    @Override
    public void onError(String message) {

    }
}
