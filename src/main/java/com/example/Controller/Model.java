package com.example.Controller;
import javax.persistence.*;

@Entity
@Table(name="risk_rules")
public class Model {
    @Id
    @GeneratedValue
    @Column(name = "ruleid")
    private Integer id;
    @Column(name = "level")
    private String level;
    @Column(name = "description")
    private String Desc;

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

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }


}

