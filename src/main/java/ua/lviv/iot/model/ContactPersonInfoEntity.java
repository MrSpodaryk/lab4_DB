package ua.lviv.iot.model;


import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "contact_person_info")
public class ContactPersonInfoEntity {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "it_company_info_id")
    private Integer itCompanyInfoId;

    public ContactPersonInfoEntity() {
    }

    public ContactPersonInfoEntity(Integer id, String name, String surname, Integer age, Integer phoneNumber, String email, Integer itCompanyInfoId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.itCompanyInfoId = itCompanyInfoId;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getItCompanyInfoId() {
        return itCompanyInfoId;
    }

    public void setItCompanyInfoId(Integer itCompanyInfoId) {
        this.itCompanyInfoId = itCompanyInfoId;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s %-15s %-15d %-15d %-30s %-5d", id, name, surname, age, phoneNumber, email, itCompanyInfoId);
    }
}
