package ua.lviv.iot.model;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "technical_level")
public class TechnicalLevelEntity {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "level")
    private String level;

    public TechnicalLevelEntity() {
    }

    public TechnicalLevelEntity(String level) {
        this.level = level;
    }

    public TechnicalLevelEntity(Integer id, String level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("%-7d %-15s", id, level);
    }
}
