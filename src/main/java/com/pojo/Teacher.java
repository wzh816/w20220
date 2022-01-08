package com.pojo;

public class Teacher {
    private Integer tid;

    private String tname;

    private Integer tage;

    private String tsex;

    private Integer tmoney;

    private Integer money;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex == null ? null : tsex.trim();
    }

    public Integer getTmoney() {
        return tmoney;
    }

    public void setTmoney(Integer tmoney) {
        this.tmoney = tmoney;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}