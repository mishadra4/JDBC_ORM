package com.md.DAO.impl;

import com.md.DAO.WorksOnDAO;
import com.md.model.PK_WorksOn;
import com.md.model.WorksOnEntity;

import java.sql.SQLException;
import java.util.List;

public class WorksOnDaoImpl implements WorksOnDAO{
    public List<WorksOnEntity> findAll() throws SQLException {
        return null;
    }

    public WorksOnEntity findById(PK_WorksOn pk_worksOn) throws SQLException {
        return null;
    }

    public int create(WorksOnEntity entity) throws SQLException {
        return 0;
    }

    public int update(WorksOnEntity entity) throws SQLException {
        return 0;
    }

    public int delete(PK_WorksOn pk_worksOn) throws SQLException {
        return 0;
    }
}
