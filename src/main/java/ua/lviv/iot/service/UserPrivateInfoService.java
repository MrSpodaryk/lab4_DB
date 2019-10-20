package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.UserPrivateInfoDAOImpl;
import ua.lviv.iot.model.UserPrivateInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class UserPrivateInfoService {

    public List<UserPrivateInfoEntity> findAll() throws SQLException {
        return new UserPrivateInfoDAOImpl().findAll();
    }

    public UserPrivateInfoEntity findById(Integer id) throws SQLException {
        return new UserPrivateInfoDAOImpl().findById(id);
    }

    public int create(UserPrivateInfoEntity entity) throws SQLException {
        return new UserPrivateInfoDAOImpl().create(entity);
    }

    public int update(UserPrivateInfoEntity entity) throws SQLException {
        return new UserPrivateInfoDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new UserPrivateInfoDAOImpl().delete(id);
    }
}
