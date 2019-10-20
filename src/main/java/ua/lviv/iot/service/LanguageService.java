package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.LanguageDAOImpl;
import ua.lviv.iot.model.LanguageEntity;

import java.sql.SQLException;
import java.util.List;

public class LanguageService {

    public List<LanguageEntity> findAll() throws SQLException {
        return new LanguageDAOImpl().findAll();
    }

    public LanguageEntity findById(Integer id) throws SQLException {
        return new LanguageDAOImpl().findById(id);
    }

    public int create(LanguageEntity entity) throws SQLException {
        return new LanguageDAOImpl().create(entity);
    }

    public int update(LanguageEntity entity) throws SQLException {
        return new LanguageDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new LanguageDAOImpl().delete(id);
    }
}
