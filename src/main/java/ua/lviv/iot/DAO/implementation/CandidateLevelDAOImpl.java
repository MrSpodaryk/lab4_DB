package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.CandidateLevelDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateLevelDAOImpl implements CandidateLevelDAO {

    private static final String FIND_ALL = "SELECT * FROM candidate_level";
    private static final String DELETE = "DELETE FROM candidate_level WHERE id=?";
    private static final String CREATE = "INSERT candidate_level (level) VALUES (?)";
    private static final String UPDATE = "UPDATE candidate_level SET level=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM candidate_level WHERE id=?";

    @Override
    public List<CandidateLevelEntity> findAll() throws SQLException {
        List<CandidateLevelEntity> candidateLevel = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    candidateLevel.add((CandidateLevelEntity)new Transformer(CandidateLevelEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return candidateLevel;
    }

    @Override
    public CandidateLevelEntity findById(Integer id) throws SQLException {
        CandidateLevelEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(CandidateLevelEntity)new Transformer(CandidateLevelEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(CandidateLevelEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, entity.getLevel());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(CandidateLevelEntity entity) throws SQLException {
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
