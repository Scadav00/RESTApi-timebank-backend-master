package net.btcmp.timebank.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LogDto {

    @NotNull
    private String userName;

    @NotNull
    private String serviceName;

    private Integer estimatedHours;

    private LocalDateTime date;

    private int averagedRatingLog;

    public LogDto(String userName, String serviceName, Integer estimatedHours, LocalDateTime date, int averagedRatingLog) {
        this.userName = userName;
        this.serviceName = serviceName;
        this.estimatedHours = estimatedHours;
        this.date = date;
        this.averagedRatingLog = averagedRatingLog;
    }

    public LogDto() {
//        empty constructor
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAveragedRatingLog() {
        return averagedRatingLog;
    }

    public void setAveragedRatingLog(int averagedRatingLog) {
        this.averagedRatingLog = averagedRatingLog;
    }
}

