package com.example.orm;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.orm.database.DatabaseHelper;
import com.example.orm.model.InfoModel;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayDataActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    @BindView(R.id.listview)
    ListView listView;

    private DatabaseHelper database_helper = null;
    private int selectPosition = -1;
    private Dao<InfoModel, Integer> informationDao;
    private List<InfoModel> informationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        ButterKnife.bind(this);
        displayData();
    }

    public void displayData(){
        try {
            informationDao =getHelper().getInformationDao();
            informationList = informationDao.queryForAll();
            final LayoutInflater layoutInflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View view = layoutInflater.inflate(R.layout.list_view,listView,false);
            listView.setAdapter(new InformationArrayAdapter(this,R.layout.list_view,informationList,informationDao));
            listView.addHeaderView(view);
            listView.setOnItemLongClickListener(this);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }


    private DatabaseHelper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return database_helper;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if(position > 0)
        {
            selectPosition = position - 1;
            showDialog();
        }
        return false;
    }

    private void showDialog() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you want to delete?");
        alertDialogBuilder.setTitle("Delete");
        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    informationDao.delete(informationList.get(selectPosition));
                    informationList.remove(selectPosition);
                    listView.invalidateViews();
                    selectPosition = -1;
                } catch (java.sql.SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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