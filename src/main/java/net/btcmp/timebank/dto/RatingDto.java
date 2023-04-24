package net.btcmp.timebank.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class RatingDto {

    @NotNull(message = "Please enter Service Id")
    private Long serviceId;

    @NotNull(message = "Please enter User Id")
    private Long userId;

    @PositiveOrZero
    @Min(0)
    @Max(5)
    private int stars;

    public RatingDto(Long serviceId, Long userId, int stars) {
        this.serviceId = serviceId;
        this.userId = userId;
        this.stars = stars;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
