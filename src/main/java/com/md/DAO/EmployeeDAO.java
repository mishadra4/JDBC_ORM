package com.pavelchak.DAO;

import com.pavelchak.model.EmployeeEntity;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO extends GeneralDAO<EmployeeEntity, Integer> {
    List<EmployeeEntity> findByName(String name) throws SQLException;

    List<EmployeeEntity> findByDeptNo(String deptNo) throws SQLException;
}
