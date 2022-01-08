package com.utils;

/**
 * @author 王志恒
 * @create 2021/12/7 19:17
 */
public class TeacherUtil {
    private Boolean goon;
    private String uname;

    public Boolean getGoon() {
        return goon;
    }

    public void setGoon(Boolean goon) {
        this.goon = goon;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public TeacherUtil() {
    }

    public TeacherUtil(Boolean goon, String uname) {
        this.goon = goon;
        this.uname = uname;
    }
}
