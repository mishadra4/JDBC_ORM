package com.md.DAO.impl;

import com.md.DAO.ProjectDAO;
import com.md.model.ProjectEntity;
import com.md.persistant.ConnectionManager;
import com.md.transformer.Transformer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDAO {
    private static final String FIND_ALL = "SELECT * FROM project";
    private static final String DELETE = "DELETE FROM project WHERE project_no=?";
    private static final String CREATE = "INSERT project (project_no, project_name, budget) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE project SET project_name=?, budget=? WHERE project_no=?";
    private static final String FIND_BY_ID = "SELECT * FROM project WHERE project_no=?";

    @Override
    public List<ProjectEntity> findAll() throws SQLException {
        List<ProjectEntity> projects = new LinkedList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    projects.add((ProjectEntity) new Transformer(ProjectEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return projects;
    }

    @Override
    public ProjectEntity findById(String id) throws SQLException {
        ProjectEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (ProjectEntity) new Transformer(ProjectEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(ProjectEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, entity.getProjectNo());
            ps.setString(2, entity.getProjectName());
            ps.setInt(3, entity.getBudget());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ProjectEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getProjectName());
            ps.setInt(2, entity.getBudget());
            ps.setString(3, entity.getProjectNo());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }
}
