package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.ContactPersonInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.model.ContactPersonInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactPersonInfoDAOImpl implements ContactPersonInfoDAO {
    private static final String FIND_ALL = "SELECT * FROM contact_person_info";
    private static final String DELETE = "DELETE FROM contact_person_info WHERE id=?";
    private static final String CREATE = "INSERT contact_person_info (name, surname, age, phone_number, email, it_company_info_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE contact_person_info SET name=?, surname=?, age=?, phone_number=?, email=?, it_company_info_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM contact_person_info WHERE id=?";

    @Override
    public List<ContactPersonInfoEntity> findAll() throws SQLException {
        List<ContactPersonInfoEntity> contactPersonInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    contactPersonInfo.add((ContactPersonInfoEntity) new Transformer(ContactPersonInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return contactPersonInfo;
    }

    @Override
    public ContactPersonInfoEntity findById(Integer id) throws SQLException {
        ContactPersonInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (ContactPersonInfoEntity) new Transformer(ContactPersonInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(ContactPersonInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getPhoneNumber());
            ps.setString(5, entity.getEmail());
            ps.setInt(6, entity.getItCompanyInfoId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ContactPersonInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setInt(3, entity.getAge());
            ps.setInt(4, entity.getPhoneNumber());
            ps.setString(5, entity.getEmail());
            ps.setInt(6, entity.getItCompanyInfoId());
            ps.setInt(7, entity.getId());
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
