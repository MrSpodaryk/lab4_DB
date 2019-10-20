package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CandidateLevelDAOImpl;
import ua.lviv.iot.DAO.implementation.TechnicalLevelDAOImpl;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.model.TechnicalLevelEntity;

import java.sql.SQLException;
import java.util.List;

public class TechnicalLevelService {

    public List<TechnicalLevelEntity> findAll() throws SQLException {
        return new TechnicalLevelDAOImpl().findAll();
    }

    public TechnicalLevelEntity findById(Integer id) throws SQLException {
        return new TechnicalLevelDAOImpl().findById(id);
    }

    public int create(TechnicalLevelEntity entity) throws SQLException {
        return new TechnicalLevelDAOImpl().create(entity);
    }

    public int update(TechnicalLevelEntity entity) throws SQLException {
        return new TechnicalLevelDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TechnicalLevelDAOImpl().delete(id);
    }
}
