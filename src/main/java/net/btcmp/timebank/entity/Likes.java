package net.btcmp.timebank.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "like_date")
    private LocalDateTime date;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "user_id")
    private Long loggedId;
//    byvale userId

//
    @Column(name = "hours")
    private Long hours;

    @Column(name = "rating_log")
    private Integer ratingLog;

    public Likes(Long id, Long serviceId, Long loggedId, Long hours, Integer ratingLog) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.serviceId = serviceId;
        this.loggedId = loggedId;
        this.hours = hours;
//        review na post get controleri
        this.ratingLog = ratingLog;

    }

    public Likes(){
        this.date= LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public void setLoggedId(Long ordererId) {
        this.loggedId = ordererId;
    }
//    -------------------------------------------------

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    //    -------------------------------------------------

    public Integer getRatingLog() {
        return ratingLog;
    }

    public void setRatingLog(Integer ratingLog) {
        this.ratingLog = ratingLog;
    }

}
