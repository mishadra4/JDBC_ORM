package com.md.DAO.impl;

import com.md.DAO.WorksOnDAO;
import com.md.model.PK_WorksOn;
import com.md.model.WorksOnEntity;
import com.md.persistant.ConnectionManager;
import com.md.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WorksOnDaoImpl implements WorksOnDAO {
    private static final String FIND_ALL = "SELECT * FROM works_on";
    private static final String DELETE = "DELETE FROM works_on WHERE emp_no=? AND project_no=?";
    private static final String CREATE = "INSERT works_on (emp_no, project_no, job, enter_date) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE works_on SET job=?, enter_date=? WHERE emp_no=? AND project_no=?";

    @Override
    public List<WorksOnEntity> findAll() throws SQLException {
        List<WorksOnEntity> works = new LinkedList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    works.add((WorksOnEntity) new Transformer(WorksOnEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return works;
    }

    @Override
    public WorksOnEntity findById(PK_WorksOn pk_worksOn) throws SQLException {
        return null;
    }

    @Override
    public int create(WorksOnEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getPk().getEmpNo());
            ps.setString(2,entity.getPk().getProjectNo());
            ps.setString(3,entity.getJob());
            ps.setDate(4,entity.getDate());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(WorksOnEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getJob());
            ps.setDate(2,entity.getDate());
            ps.setInt(3,entity.getPk().getEmpNo());
            ps.setString(4,entity.getPk().getProjectNo());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(PK_WorksOn id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id.getEmpNo());
            ps.setString(2,id.getProjectNo());
            return ps.executeUpdate();
        }
    }
}
