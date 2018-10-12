package com.example.orm_lite_db.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "goal.db";
    private static final int DB_VERSION = 1;
    private RuntimeExceptionDao<Goal, String> goalRuntimeExceptionDao = null;
    private GoalDao goalDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Goal.class);
        } catch (android.database.SQLException e) {
            Log.e(TAG, "Error creating DB - " + DATABASE_NAME);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Goal.class, true);
            onCreate(database, connectionSource);
        } catch (android.database.SQLException e) {
            Log.e(TAG, "Error upgrading DB " + DATABASE_NAME + " from ver " + oldVersion);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public GoalDao getGoalDao() throws SQLException {
        if (goalDao == null) {
            goalDao = new GoalDao(getConnectionSource(), Goal.class);
        }
        return goalDao;
    }


    @Override
    public void close() {
        super.close();
        goalDao = null;
    }
}
