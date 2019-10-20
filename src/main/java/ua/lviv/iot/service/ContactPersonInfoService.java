package ua.lviv.iot.service;

import ua.lviv.iot.DAO.implementation.ContactPersonInfoDAOImpl;
import ua.lviv.iot.model.ContactPersonInfoEntity;

import java.sql.SQLException;
import java.util.List;

public class ContactPersonInfoService {

    public List<ContactPersonInfoEntity> findAll() throws SQLException {
        return new ContactPersonInfoDAOImpl().findAll();
    }

    public ContactPersonInfoEntity findById(Integer id) throws SQLException {
        return new ContactPersonInfoDAOImpl().findById(id);
    }

    public int create(ContactPersonInfoEntity entity) throws SQLException {
        return new ContactPersonInfoDAOImpl().create(entity);
    }

    public int update(ContactPersonInfoEntity entity) throws SQLException {
        return new ContactPersonInfoDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new ContactPersonInfoDAOImpl().delete(id);
    }
}
