package com.example.orm_lite_db.database;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class InternDAO extends BaseDaoImpl<Intern, String> {

    protected InternDAO(ConnectionSource connectionSource, Class<Intern> dataClass)
            throws android.database.SQLException, java.sql.SQLException {
        super(connectionSource,dataClass);
    }
    public List<Intern> getAllIntern()throws SQLException, java.sql.SQLException{
        return this.queryForAll();
    }

    public List<Intern> getInternByName(String name) throws SQLException, java.sql.SQLException{
        QueryBuilder<Intern, String> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Intern.NAME, "First name");
        PreparedQuery<Intern> preparedQuery = queryBuilder.prepare();
        List<Intern> internList = query(preparedQuery);
        return internList;

    }
}
