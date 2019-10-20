package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.UserInfoDAOImpl;
import ua.lviv.iot.model.UserInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class UserInfoService {

    public List<UserInfoEntity> findAll() throws SQLException {
        return new UserInfoDAOImpl().findAll();
    }

    public UserInfoEntity findById(Integer id) throws SQLException {
        return new UserInfoDAOImpl().findById(id);
    }

    public int create(UserInfoEntity entity) throws SQLException {
        return new UserInfoDAOImpl().create(entity);
    }

    public int update(UserInfoEntity entity) throws SQLException {
        return new UserInfoDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new UserInfoDAOImpl().delete(id);
    }
}
