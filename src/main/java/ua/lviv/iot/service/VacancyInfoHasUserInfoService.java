package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.VacancyInfoHasUserInfoDAOImpl;
import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class VacancyInfoHasUserInfoService {

    public List<VacancyInfoHasUserInfoEntity> findAll() throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().findAll();
    }

    public VacancyInfoHasUserInfoEntity findById(Integer id1, Integer id2) throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().findById(id1, id2);
    }

    public int create(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().create(entity);
    }

    public int update(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().update(entity);
    }

    public int delete(Integer id1, Integer id2) throws SQLException {
        return new VacancyInfoHasUserInfoDAOImpl().delete(id1, id2);
    }
}
