package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "user_private_info")
public class UserPrivateInfoEntity {

    @PrimaryKey
    @Column(name = "user_info_id")
    private Integer userInfoId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public UserPrivateInfoEntity() {
    }

    public UserPrivateInfoEntity(Integer userInfoId, String login, String password) {
        this.userInfoId = userInfoId;
        this.login = login;
        this.password = password;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s %-15s", userInfoId, login, password);
    }
}
