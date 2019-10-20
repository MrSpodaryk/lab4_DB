package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "vacancy_info")
public class VacancyInfoEntity {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "it_company_info_id")
    private Integer itCompanyInfoId;
    @Column(name = "language_id")
    private Integer languageId;
    @Column(name = "level_of_experience_id")
    private Integer levelOfExperienceId;

    public VacancyInfoEntity() {
    }

    public VacancyInfoEntity(Integer id, String description, String projectName, Integer itCompanyInfoId, Integer languageId, Integer levelOfExperienceId) {
        this.id = id;
        this.description = description;
        this.projectName = projectName;
        this.itCompanyInfoId = itCompanyInfoId;
        this.languageId = languageId;
        this.levelOfExperienceId = levelOfExperienceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getItCompanyInfoId() {
        return itCompanyInfoId;
    }

    public void setItCompanyInfoId(Integer itCompanyInfoId) {
        this.itCompanyInfoId = itCompanyInfoId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getLevelOfExperienceId() {
        return levelOfExperienceId;
    }

    public void setLevelOfExperienceId(Integer levelOfExperienceId) {
        this.levelOfExperienceId = levelOfExperienceId;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-20s %-15s %-7d %-7d %-7d", id, description, projectName, itCompanyInfoId,
                languageId, levelOfExperienceId);
    }
}
