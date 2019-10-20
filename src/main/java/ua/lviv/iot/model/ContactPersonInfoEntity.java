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
    private int age;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "it_company_info_id")
    private int itCompanyInfoId;

    public ContactPersonInfoEntity() {
    }

    public ContactPersonInfoEntity(Integer id, String name, String surname, int age, int phoneNumber, String email, int itCompanyInfoId) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getItCompanyInfoId() {
        return itCompanyInfoId;
    }

    public void setItCompanyInfoId(int itCompanyInfoId) {
        this.itCompanyInfoId = itCompanyInfoId;
    }

    @Override
    public String toString() {
        return "ContactPersonInfoEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", itCompanyInfoId=" + itCompanyInfoId +
                '}';
    }
}
