package com.example.ejerciciosSesiones4_5_6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "latops")
public class Latop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    private int yearr;
    private String sn;

    // Constructors

    public Latop() {
    }

    public Latop(Long id, String mark, String model, int yearr, String sn) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.yearr = yearr;
        this.sn = sn;
    }

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearr() {
        return yearr;
    }

    public void setYearr(int yearr) {
        this.yearr = yearr;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
