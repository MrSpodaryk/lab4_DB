package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.TechnicalLevelDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.LevelOfExperienceEntity;
import ua.lviv.iot.model.TechnicalLevelEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TechnicalLevelDAOImpl implements TechnicalLevelDAO {

    private static final String FIND_ALL = "SELECT * FROM technical_level";
    private static final String DELETE = "DELETE FROM technical_level WHERE id=?";
    private static final String CREATE = "INSERT technical_level (id, level) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE technical_level SET level=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM technical_level WHERE id=?";

    @Override
    public List<TechnicalLevelEntity> findAll() throws SQLException {
        List<TechnicalLevelEntity> technicalLevel = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    technicalLevel.add((TechnicalLevelEntity) new Transformer(TechnicalLevelEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return technicalLevel;
    }

    @Override
    public TechnicalLevelEntity findById(Integer id) throws SQLException {
        TechnicalLevelEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (TechnicalLevelEntity) new Transformer(TechnicalLevelEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(TechnicalLevelEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLevel());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(TechnicalLevelEntity entity) throws SQLException {
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
