package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CandidateLevelDAOImpl;
import ua.lviv.iot.model.CandidateLevelEntity;

import java.sql.SQLException;
import java.util.List;

public class CandidateLevelService {

    public List<CandidateLevelEntity> findAll() throws SQLException {
        return new CandidateLevelDAOImpl().findAll();
    }

    public static CandidateLevelEntity findById(Integer id) throws SQLException {
        return new CandidateLevelDAOImpl().findById(id);
    }

    public int create(CandidateLevelEntity entity) throws SQLException {
        return new CandidateLevelDAOImpl().create(entity);
    }

    public int update(CandidateLevelEntity entity) throws SQLException {
        return new CandidateLevelDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new CandidateLevelDAOImpl().delete(id);
    }
}
