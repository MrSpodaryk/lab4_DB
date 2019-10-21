package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "user_info")
public class UserInfoEntity {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "technical_level_id")
    private Integer technicalLevelId;
    @Column(name = "level_of_experience_id")
    private Integer levelOfExperienceId;

    public UserInfoEntity() {
    }

    public UserInfoEntity(String name, String surname, Integer age, Integer technicalLevelId, Integer levelOfExperienceId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.technicalLevelId = technicalLevelId;
        this.levelOfExperienceId = levelOfExperienceId;
    }

    public UserInfoEntity(Integer id, String name, String surname, Integer age, Integer technicalLevelId,
                          Integer levelOfExperienceId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.technicalLevelId = technicalLevelId;
        this.levelOfExperienceId = levelOfExperienceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTechnicalLevelId() {
        return technicalLevelId;
    }

    public void setTechnicalLevelId(Integer technicalLevelId) {
        this.technicalLevelId = technicalLevelId;
    }

    public Integer getLevelOfExperienceId() {
        return levelOfExperienceId;
    }

    public void setLevelOfExperienceId(Integer levelOfExperienceId) {
        levelOfExperienceId = levelOfExperienceId;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s %-15s %-7d %-7d %-7d", id, name, surname, age, technicalLevelId,
                levelOfExperienceId);
    }
}
