package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

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
    private int age;
    @Column(name = "technical_level_id")
    private int technicalLevelId;
    @Column(name = "level_of_experience_id")
    private int LevelOfExperienceId;

    public UserInfoEntity() {
    }

    public UserInfoEntity(Integer id, String name, String surname, int age, int technicalLevelId,
                          int levelOfExperienceId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.technicalLevelId = technicalLevelId;
        LevelOfExperienceId = levelOfExperienceId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTechnicalLevelId() {
        return technicalLevelId;
    }

    public void setTechnicalLevelId(int technicalLevelId) {
        this.technicalLevelId = technicalLevelId;
    }

    public int getLevelOfExperienceId() {
        return LevelOfExperienceId;
    }

    public void setLevelOfExperienceId(int levelOfExperienceId) {
        LevelOfExperienceId = levelOfExperienceId;
    }

    @Override
    public String toString() {
        return "UserInfoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", technicalLevelId=" + technicalLevelId +
                ", LevelOfExperienceId=" + LevelOfExperienceId +
                '}';
    }
}
