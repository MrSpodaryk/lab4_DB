package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.ItCompanyInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.ItCompanyInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItCompanyInfoDAOImpl implements ItCompanyInfoDAO {

    private static final String FIND_ALL = "SELECT * FROM it_company_info";
    private static final String DELETE = "DELETE FROM it_company_info WHERE id=?";
    private static final String CREATE = "INSERT it_company_info (id, name) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE it_company_info SET name=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM it_company_info WHERE id=?";

    @Override
    public List<ItCompanyInfoEntity> findAll() throws SQLException {
        List<ItCompanyInfoEntity> itCompanyInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    itCompanyInfo.add((ItCompanyInfoEntity) new Transformer(ItCompanyInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return itCompanyInfo;
    }

    @Override
    public ItCompanyInfoEntity findById(Integer id) throws SQLException {
        ItCompanyInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (ItCompanyInfoEntity) new Transformer(ItCompanyInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(ItCompanyInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ItCompanyInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());
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
