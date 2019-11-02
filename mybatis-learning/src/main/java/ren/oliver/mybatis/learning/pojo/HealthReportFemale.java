package ren.oliver.mybatis.learning.pojo;

import java.math.BigDecimal;

public class HealthReportFemale extends HealthReport {

    private String item;

    private BigDecimal score;

    private Integer userId;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
