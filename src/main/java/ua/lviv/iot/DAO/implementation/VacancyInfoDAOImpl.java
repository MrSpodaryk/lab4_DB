package ua.lviv.iot.DAO.implementation;

import ua.lviv.iot.DAO.VacancyInfoDAO;
import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.VacancyInfoEntity;
import ua.lviv.iot.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyInfoDAOImpl implements VacancyInfoDAO {

    private static final String FIND_ALL = "SELECT * FROM vacancy_info";
    private static final String DELETE = "DELETE FROM vacancy_info WHERE id=?";
    private static final String CREATE = "INSERT vacancy_info (description, project_name, it_company_info_id, " +
            "language_id, level_of_experience_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE vacancy_info SET description=?, project_name=?, it_company_info_id=?, language_id=?, level_of_experience_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM vacancy_info WHERE id=?";

    @Override
    public List<VacancyInfoEntity> findAll() throws SQLException {
        List<VacancyInfoEntity> vacancyInfo = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    vacancyInfo.add((VacancyInfoEntity) new Transformer(VacancyInfoEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return vacancyInfo;
    }

    @Override
    public VacancyInfoEntity findById(Integer id) throws SQLException {
        VacancyInfoEntity entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity = (VacancyInfoEntity) new Transformer(VacancyInfoEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(VacancyInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1, entity.getDescription());
            ps.setString(2, entity.getProjectName());
            ps.setInt(3, entity.getItCompanyInfoId());
            ps.setInt(4, entity.getLanguageId());
            ps.setInt(5, entity.getLevelOfExperienceId());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(VacancyInfoEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getDescription());
            ps.setString(2, entity.getProjectName());
            ps.setInt(3, entity.getItCompanyInfoId());
            ps.setInt(4, entity.getLanguageId());
            ps.setInt(5, entity.getLevelOfExperienceId());
            ps.setInt(6, entity.getId());
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
