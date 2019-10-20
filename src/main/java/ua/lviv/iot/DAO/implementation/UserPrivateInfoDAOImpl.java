package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.UserPrivateInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.LanguageEntity;
import ua.lviv.iot.model.UserPrivateInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserPrivateInfoDAOImpl implements UserPrivateInfoDAO {

    private static final String FIND_ALL = "SELECT * FROM user_private_info";
    private static final String DELETE = "DELETE FROM user_private_info WHERE user_info_id=?";
    private static final String CREATE = "INSERT user_private_info (user_info_id, login, password) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE user_private_info SET login=?, password=? WHERE user_info_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM user_private_info WHERE user_info_id=?";

    @Override
    public List<UserPrivateInfoEntity> findAll() throws SQLException {
        List<UserPrivateInfoEntity> userPrivateInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    userPrivateInfo.add((UserPrivateInfoEntity) new Transformer(UserPrivateInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return userPrivateInfo;
    }

    @Override
    public UserPrivateInfoEntity findById(Integer id) throws SQLException {
        UserPrivateInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (UserPrivateInfoEntity) new Transformer(UserPrivateInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(UserPrivateInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getUserInfoId());
            ps.setString(2, entity.getLogin());
            ps.setString(3, entity.getPassword());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(UserPrivateInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setInt(3, entity.getUserInfoId());
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
