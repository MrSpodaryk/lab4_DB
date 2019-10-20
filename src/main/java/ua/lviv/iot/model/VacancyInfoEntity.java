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
    private int itCompanyInfoId;
    @Column(name = "language_id")
    private int languageId;
    @Column(name = "level_of_experience_id")
    private int levelOfExperienceId;

    public VacancyInfoEntity() {
    }

    public VacancyInfoEntity(Integer id, String description, String projectName, int itCompanyInfoId, int languageId, int levelOfExperienceId) {
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

    public int getItCompanyInfoId() {
        return itCompanyInfoId;
    }

    public void setItCompanyInfoId(int itCompanyInfoId) {
        this.itCompanyInfoId = itCompanyInfoId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getLevelOfExperienceId() {
        return levelOfExperienceId;
    }

    public void setLevelOfExperienceId(int levelOfExperienceId) {
        this.levelOfExperienceId = levelOfExperienceId;
    }

    @Override
    public String toString() {
        return "VacancyInfoEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", projectName='" + projectName + '\'' +
                ", itCompanyInfoId=" + itCompanyInfoId +
                ", languageId=" + languageId +
                ", levelOfExperienceId=" + levelOfExperienceId +
                '}';
    }
}
