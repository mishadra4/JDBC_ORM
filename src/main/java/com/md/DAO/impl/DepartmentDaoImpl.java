package com.md.DAO.impl;

import com.md.DAO.DepartmentDAO;
import com.md.model.DepartmentEntity;
import com.md.persistant.ConnectionManager;
import com.md.transformer.Transformer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDAO {
    public static final String FIND_ALL = "SELECT * FROM department";
    public static final String FIND_BY_ID = "SELECT * FROM department WHERE dept_no=?";
    public static final String DELETE = "DELETE FROM department WHERE dept_no=?";
    public static final String CREATE = "INSERT department (dept_no, dept_name, location) VALUES (?, ?, ?)";
    public static final String UPDATE = "UPDATE department SET dept_name=?, location=? WHERE dept_no=?";
    public List<DepartmentEntity> findAll() throws SQLException {
        List<DepartmentEntity> departments = new LinkedList<DepartmentEntity>();
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL);
        while(resultSet.next()){
            departments.add((DepartmentEntity)new Transformer<DepartmentEntity>(DepartmentEntity.class).fromResultSetToEntity(resultSet));
        }
        return departments;
    }

    public DepartmentEntity findById(String s) throws SQLException {
        DepartmentEntity department;
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
        statement.setString(1,s);
        ResultSet resultSet = statement.executeQuery();
        department = (DepartmentEntity) new Transformer<DepartmentEntity>(DepartmentEntity.class).fromResultSetToEntity(resultSet);
        connection.close();
        return department;
    }

    public int create(DepartmentEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,entity.getDeptNo());
            ps.setString(2,entity.getDeptName());
            ps.setString(3,entity.getLocation());
            return ps.executeUpdate();
        }
    }

    public int update(DepartmentEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getDeptNo());
            preparedStatement.setString(2, entity.getDeptName());
            preparedStatement.setString(3, entity.getLocation());
            return preparedStatement.executeUpdate();
        }
    }

    public int delete(String s) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1,s);
            return ps.executeUpdate();
        }
    }
}
