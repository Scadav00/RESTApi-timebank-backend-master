package net.btcmp.timebank.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating_date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
//    TODO check: JOIN COLUMN WITH ALTER TABLE in schema
    private Service serviceId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "stars")
    private int stars;


    public Rating(Long id, LocalDateTime date, Service serviceId, User userId, int stars) {
        this.id = id;
        this.date = date;
        this.serviceId = serviceId;
        this.userId = userId;
        this.stars = stars;
    }

    public Rating(){
    //empty constructor

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
