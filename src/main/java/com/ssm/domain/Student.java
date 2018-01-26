package com.ssm.domain;

import java.io.Serializable;

public class Student implements Serializable {

    private int sid;
    private String sname,spassword;

    public Student() {
    }

    public Student(String sname, String spassword) {
        this.sname = sname;
        this.spassword = spassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }
}
