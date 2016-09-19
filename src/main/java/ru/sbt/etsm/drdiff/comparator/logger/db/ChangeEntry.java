package ru.sbt.etsm.drdiff.comparator.logger.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sbt-morozov-kv on 06.09.2016.
 */

@Entity(name = "ChangeEntry")
public class ChangeEntry {

    @Id
    @GeneratedValue
    private Long id;

    private String place;

    @Column(length = 4000)
    private String change;
    private String activator;
    private String role;
    private String type;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getActivator() {
        return activator;
    }

    public void setActivator(String activator) {
        this.activator = activator;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
