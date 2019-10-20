package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.LanguageDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.ItCompanyInfoEntity;
import ua.lviv.iot.model.LanguageEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAOImpl implements LanguageDAO {

    private static final String FIND_ALL = "SELECT * FROM language";
    private static final String DELETE = "DELETE FROM language WHERE id=?";
    private static final String CREATE = "INSERT language (id, language) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE language SET language=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM language WHERE id=?";

    @Override
    public List<LanguageEntity> findAll() throws SQLException {
        List<LanguageEntity> language = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    language.add((LanguageEntity) new Transformer(LanguageEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return language;
    }

    @Override
    public LanguageEntity findById(Integer id) throws SQLException {
        LanguageEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (LanguageEntity) new Transformer(LanguageEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(LanguageEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getLanguage());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(LanguageEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getLanguage());
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
