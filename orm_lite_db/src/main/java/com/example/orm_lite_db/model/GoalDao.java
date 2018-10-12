package com.example.orm_lite_db.model;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class GoalDao extends BaseDaoImpl<Goal, String> {

    protected GoalDao(ConnectionSource connectionSource, Class<Goal> dataClass)
            throws android.database.SQLException, java.sql.SQLException {
        super(connectionSource,dataClass);
    }
    public List<Goal> getAllRoles()throws SQLException, java.sql.SQLException{
        return this.queryForAll();
    }

    public List<Goal> getGoalByName(String name) throws SQLException, java.sql.SQLException{
        QueryBuilder<Goal, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Goal.NAME, name);
        PreparedQuery<Goal> preparedQuery = queryBuilder.prepare();
        List<Goal> goalList = query(preparedQuery);
        return goalList;

    }
}
