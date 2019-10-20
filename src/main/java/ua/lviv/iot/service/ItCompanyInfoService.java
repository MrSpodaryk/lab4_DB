package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.CandidateLevelDAOImpl;
import ua.lviv.iot.DAO.implementation.ItCompanyInfoDAOImpl;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.model.ItCompanyInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class ItCompanyInfoService {

    public List<ItCompanyInfoEntity> findAll() throws SQLException {
        return new ItCompanyInfoDAOImpl().findAll();
    }

    public ItCompanyInfoEntity findById(Integer id) throws SQLException {
        return new ItCompanyInfoDAOImpl().findById(id);
    }

    public int create(ItCompanyInfoEntity entity) throws SQLException {
        return new ItCompanyInfoDAOImpl().create(entity);
    }

    public int update(ItCompanyInfoEntity entity) throws SQLException {
        return new ItCompanyInfoDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new ItCompanyInfoDAOImpl().delete(id);
    }
}
