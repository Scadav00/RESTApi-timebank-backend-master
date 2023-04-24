package net.btcmp.timebank.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewLikesDto {

    @NotNull(message = "Please, enter Service Id.")
    private Long serviceId;

    @NotNull(message = "Please, enter User Id.")
    private Long loggedId;

    @Min(value = 0L, message = "The value must be positive.")
    private Long hours;

    @Min(value = 0L, message = "The value must be between 0-5.")
    @Max(value = 5L, message = "The value must be between 0-5.")
    private int ratingLog;

    public NewLikesDto(Long serviceId, Long loggedId, Long hours, int ratingLog) {
        this.serviceId = serviceId;
        this.loggedId = loggedId;
        this.hours = hours;
        this.ratingLog = ratingLog;
    }

    public NewLikesDto() {
//        empty constructor
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    //    -------------------------------------------------

    public Long getLoggedId() {
        return loggedId;
    }

    public void setLoggedId(Long loggedId) {
        this.loggedId = loggedId;
    }

    //    -------------------------------------------------

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public int getRatingLog() {
        return ratingLog;
    }

    public void setRatingLog(int ratingLog) {
        this.ratingLog = ratingLog;
    }


}
