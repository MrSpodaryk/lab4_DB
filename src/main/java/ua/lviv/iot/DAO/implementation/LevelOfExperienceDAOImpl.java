package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.LevelOfExperienceDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.LanguageEntity;
import ua.lviv.iot.model.LevelOfExperienceEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LevelOfExperienceDAOImpl implements LevelOfExperienceDAO {

    private static final String FIND_ALL = "SELECT * FROM level_of_experience";
    private static final String DELETE = "DELETE FROM level_of_experience WHERE id=?";
    private static final String CREATE = "INSERT level_of_experience (id, level) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE level_of_experience SET level=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM level_of_experience WHERE id=?";

    @Override
    public List<LevelOfExperienceEntity> findAll() throws SQLException {
        List<LevelOfExperienceEntity> levelOfExperience = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    levelOfExperience.add((LevelOfExperienceEntity) new Transformer(LevelOfExperienceEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return levelOfExperience;
    }

    @Override
    public LevelOfExperienceEntity findById(Integer id) throws SQLException {
        LevelOfExperienceEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (LevelOfExperienceEntity) new Transformer(LevelOfExperienceEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(LevelOfExperienceEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLevel());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(LevelOfExperienceEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getLevel());
            ps.setInt(2, entity.getId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
}
