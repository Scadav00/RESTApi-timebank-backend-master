package net.btcmp.timebank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "description_of_hours")
    private String descriptionOfService;

    @Column(name = "estimated_hours")
    private int estimatedHours;

    @Column(name = "averaged_rating")
    @NotNull
    private Double rating;

    @ManyToOne
    @JoinColumn(name="user_id",nullable=false)
    @JsonIgnoreProperties({"password"})
    private User user;

    public Service() {
//        empty constructor
    }

    public Service(Long id, String serviceName, String descriptionOfService, int estimatedHours, double rating) {
        this.id = id;
        this.serviceName = serviceName;
        this.descriptionOfService = descriptionOfService;
        this.estimatedHours = estimatedHours;
        this.rating = rating;

    }

    public String getDescriptionOfService() {return descriptionOfService;}

    public void setDescriptionOfService(String description) {
        this.descriptionOfService = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

//    --------------------------------------

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    --------------------------------------

    public int getEstimatedHours() { return estimatedHours; }

    public void setEstimatedHours(int estimatedHours) { this.estimatedHours = estimatedHours; }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
