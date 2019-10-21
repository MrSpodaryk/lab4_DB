package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.UserInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.UserInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO {

    private static final String FIND_ALL = "SELECT * FROM user_info";
    private static final String DELETE = "DELETE FROM user_info WHERE id=?";
    private static final String CREATE = "INSERT user_info (name, surname, age, technical_level_id, " +
            "level_of_experience_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_info SET name=?, surname=?, age=?, technical_level_id=?," +
            " level_of_experience_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user_info WHERE id=?";

    @Override
    public List<UserInfoEntity> findAll() throws SQLException {
        List<UserInfoEntity> userInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    userInfo.add((UserInfoEntity) new Transformer(UserInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return userInfo;
    }

    @Override
    public UserInfoEntity findById(Integer id) throws SQLException {
        UserInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (UserInfoEntity) new Transformer(UserInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(UserInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getTechnicalLevelId());
            ps.setInt(5, entity.getLevelOfExperienceId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(UserInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getTechnicalLevelId());
            ps.setInt(5, entity.getLevelOfExperienceId());
            ps.setInt(6, entity.getId());
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
