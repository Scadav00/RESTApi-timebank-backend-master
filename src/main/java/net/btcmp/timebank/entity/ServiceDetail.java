package net.btcmp.timebank.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class ServiceDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "description_of_hours")
    private String descriptionOfService;

    @Column(name = "estimated_hours")
    private int estimatedHours;

    @Column(name = "averaged_rating")
    @Nullable
    private Double averagedRating;


//    rating average excluded for now

    public ServiceDetail() {
//        empty constructor

    }

    public ServiceDetail(Long serviceId, String serviceName, String descriptionOfService, int estimatedHours, Double averagedRating) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.descriptionOfService = descriptionOfService;
        this.estimatedHours = estimatedHours;
        this.averagedRating = averagedRating;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long id) {
        this.serviceId = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescriptionOfService() {
        return descriptionOfService;
    }

    public void setDescriptionOfService(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public Double getAveragedRating() {
        return averagedRating;
    }

    public void setAveragedRating(Double averagedRating) {
        this.averagedRating = averagedRating;
    }

}
