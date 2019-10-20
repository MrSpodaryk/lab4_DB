package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CandidateLevelDAOImpl;
import ua.lviv.iot.DAO.implementation.LevelOfExperienceDAOImpl;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.model.LevelOfExperienceEntity;

import java.sql.SQLException;
import java.util.List;

public class LevelOfExperienceService {

    public List<LevelOfExperienceEntity> findAll() throws SQLException {
        return new LevelOfExperienceDAOImpl().findAll();
    }

    public LevelOfExperienceEntity findById(Integer id) throws SQLException {
        return new LevelOfExperienceDAOImpl().findById(id);
    }

    public int create(LevelOfExperienceEntity entity) throws SQLException {
        return new LevelOfExperienceDAOImpl().create(entity);
    }

    public int update(LevelOfExperienceEntity entity) throws SQLException {
        return new LevelOfExperienceDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new LevelOfExperienceDAOImpl().delete(id);
    }
}
