package com.md.DAO.impl;

import com.md.DAO.EmployeeDAO;
import com.md.model.EmployeeEntity;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {
    public List<EmployeeEntity> findAll() throws SQLException {
        return null;
    }

    public EmployeeEntity findById(Integer integer) throws SQLException {
        return null;
    }

    public int create(EmployeeEntity entity) throws SQLException {
        return 0;
    }

    public int update(EmployeeEntity entity) throws SQLException {
        return 0;
    }

    public int delete(Integer integer) throws SQLException {
        return 0;
    }

    public List<EmployeeEntity> findByName(String name) throws SQLException {
        return null;
    }

    public List<EmployeeEntity> findByDeptNo(String deptNo) throws SQLException {
        return null;
    }
}
