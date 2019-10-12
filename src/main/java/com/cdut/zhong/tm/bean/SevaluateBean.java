package com.cdut.zhong.tm.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SevaluateBean {
    private String evaluate;

    private Date evaluatetime;

    private String username;

    private String dateString;

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public Date getEvaluatetime() {
        return evaluatetime;
    }

    public void setEvaluatetime(Date evaluatetime) {
        this.evaluatetime = evaluatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public String toString() {
        return "SevaluateBean{" +
                "evaluate='" + evaluate + '\'' +
                ", evaluatetime=" + evaluatetime +
                ", username='" + username + '\'' +
                ", dateString='" + dateString + '\'' +
                '}';
    }
}
