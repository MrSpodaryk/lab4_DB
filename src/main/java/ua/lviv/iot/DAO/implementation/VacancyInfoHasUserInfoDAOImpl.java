package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.VacancyInfoHasUserInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.VacancyInfoEntity;
import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class VacancyInfoHasUserInfoDAOImpl implements VacancyInfoHasUserInfoDAO {

    private static final String FIND_ALL = "SELECT * FROM vacancy_info_has_user_info";
    private static final String DELETE = "DELETE FROM vacancy_info_has_user_info WHERE vacancy_info_id=? AND user_info_id=?";
    private static final String CREATE = "INSERT vacancy_info_has_user_info (vacancy_info_id, user_info_id, comment, approve, candidate_level_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE vacancy_info_has_user_info SET comment=?, approve=?, candidate_level_id=? WHERE vacancy_info_id=? AND user_info_id=?";
    private static final String FIND_BY_ID = "SELECT * FROM vacancy_info_has_user_info WHERE vacancy_info_id=? AND user_info_id=?";

    @Override
    public List<VacancyInfoHasUserInfoEntity> findAll() throws SQLException {
        List<VacancyInfoHasUserInfoEntity> vacancyInfoHasUserInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    vacancyInfoHasUserInfo.add((VacancyInfoHasUserInfoEntity) new Transformer(VacancyInfoHasUserInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return vacancyInfoHasUserInfo;
    }

    @Override
    public VacancyInfoHasUserInfoEntity findById(Integer vacancyId, Integer userId) throws SQLException {
        VacancyInfoHasUserInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, vacancyId);
            ps.setInt(2, userId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (VacancyInfoHasUserInfoEntity) new Transformer(VacancyInfoHasUserInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getVacancyInfoId());
            ps.setInt(2, entity.getUserInfoId());
            ps.setString(3, entity.getComment());
            ps.setBoolean(4, entity.isApprove());
            ps.setInt(5, entity.getCandidateLevelId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(VacancyInfoHasUserInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getComment());
            ps.setBoolean(2, entity.isApprove());
            ps.setInt(3, entity.getCandidateLevelId());
            ps.setInt(4, entity.getVacancyInfoId());
            ps.setInt(5, entity.getUserInfoId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer vacancyId, Integer userId) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, vacancyId);
            ps.setInt(2, userId);
            return ps.executeUpdate();
        }
    }
}
