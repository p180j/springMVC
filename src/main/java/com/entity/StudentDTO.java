package com.entity;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息DTO
 */
@Component
public class StudentDTO implements Serializable {
    private String stuNo; //学生学号
    private String stuName; //名字
    private String stuAge; //年龄
    private  String cno; //课程号
    private  String score; //分数
    private String stuGender;//性别
    /** 更新时间 */
    private Date modifyDate;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
