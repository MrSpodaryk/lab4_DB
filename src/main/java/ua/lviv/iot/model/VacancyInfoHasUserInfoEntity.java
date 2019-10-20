package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "vacancy_info_has_user_info")
public class VacancyInfoHasUserInfoEntity {

    @PrimaryKey
    @Column(name = "vacancy_info_id")
    private Integer vacancyInfoId;
    @PrimaryKey
    @Column(name = "user_info_id")
    private int userInfoId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "approve")
    private boolean approve;
    @Column(name = "candidate_level_id")
    private int candidateLevelId;

    public VacancyInfoHasUserInfoEntity() {
    }

    public VacancyInfoHasUserInfoEntity(Integer vacancyInfoId, int userInfoId, String comment, boolean approve, int candidateLevelId) {
        this.vacancyInfoId = vacancyInfoId;
        this.userInfoId = userInfoId;
        this.comment = comment;
        this.approve = approve;
        this.candidateLevelId = candidateLevelId;
    }

    public Integer getVacancyInfoId() {
        return vacancyInfoId;
    }

    public void setVacancyInfoId(Integer vacancyInfoId) {
        this.vacancyInfoId = vacancyInfoId;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public int getCandidateLevelId() {
        return candidateLevelId;
    }

    public void setCandidateLevelId(int candidateLevelId) {
        this.candidateLevelId = candidateLevelId;
    }

    @Override
    public String toString() {
        return "VacancyInfoHasUserInfoEntity{" +
                "vacancyInfoId=" + vacancyInfoId +
                ", userInfoId=" + userInfoId +
                ", comment='" + comment + '\'' +
                ", approve=" + approve +
                ", candidateLevelId=" + candidateLevelId +
                '}';
    }
}
