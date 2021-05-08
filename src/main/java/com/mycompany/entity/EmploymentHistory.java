
package com.mycompany.entity;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class EmploymentHistory {
    private Integer id;
    private Date beginDate;
    private Date endDate;
    private String jobDescription;
    private User user;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id, Date beginDate, Date endDate, String jobDescription, User user) {
        this.id = id;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "EmploymentHistroy{" + "id=" + id + ", beginDate=" + beginDate + ", endDate=" + endDate + ", jobDescription=" + jobDescription + ", user=" + user + '}';
    }
    
    
}
