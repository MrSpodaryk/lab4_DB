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
    private Integer userInfoId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "approve")
    private boolean approve;
    @Column(name = "candidate_level_id")
    private Integer candidateLevelId;

    public VacancyInfoHasUserInfoEntity() {
    }

    public VacancyInfoHasUserInfoEntity(Integer userInfoId, String comment, boolean approve, Integer candidateLevelId) {
        this.userInfoId = userInfoId;
        this.comment = comment;
        this.approve = approve;
        this.candidateLevelId = candidateLevelId;
    }

    public VacancyInfoHasUserInfoEntity(Integer vacancyInfoId, Integer userInfoId, String comment, boolean approve, Integer candidateLevelId) {
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

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
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

    public Integer getCandidateLevelId() {
        return candidateLevelId;
    }

    public void setCandidateLevelId(Integer candidateLevelId) {
        this.candidateLevelId = candidateLevelId;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-7d %-20s %-7d %-7d", vacancyInfoId, userInfoId, comment, approve,
                candidateLevelId);
    }
}
