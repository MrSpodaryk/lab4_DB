package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "language")
public class LanguageEntity {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "language")
    private String language;

    public LanguageEntity() {
    }

    public LanguageEntity(Integer id, String language) {
        this.id = id;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s", id, language);
    }
}
