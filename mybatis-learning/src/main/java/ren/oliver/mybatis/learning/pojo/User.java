package ren.oliver.mybatis.learning.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Integer id;

    private String userName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String note;

    private Position position;

    private List<JobHistory> jobs;

    private List<HealthReport> healthReports;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Position getPosition() {
        return position;
    }

    public void setPositionId(Position position) {
        this.position = position;
    }

    public List<JobHistory> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobHistory> jobs) {
        this.jobs = jobs;
    }

    public List<HealthReport> getHealthReports() {
        return this.healthReports;
    }

    public void setHealthReports(List<HealthReport> healthReports) {
        this.healthReports = healthReports;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void getRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", realName="
                + realName + ", sex=" + sex + ", mobile=" + mobile + ", email="
                + email + ", note=" + note + ", positionId=" + position.getId() + "]";
    }

}
