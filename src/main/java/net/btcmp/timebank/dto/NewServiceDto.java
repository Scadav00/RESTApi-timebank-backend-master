package net.btcmp.timebank.dto;

import javax.validation.constraints.*;

public class NewServiceDto {

    @NotBlank(message = "Service name can't be empty.")
    @Size(max = 1000, message = "Service name cannot be greater than 1000.")
    private String serviceName;

    @NotBlank(message = "Description of the service can't be empty.")
    private String descriptionOfService;

    @NotNull(message = "Please enter User Id")
    private Long userId;

    @NotNull
    @Positive
    @Min(1)
    private int estimatedHours;

    //    @Id
////    selfGenerate!
//    private Long id;


    public NewServiceDto() {

    }

    public NewServiceDto(String serviceName, String descriptionOfService, Long userId, int estimatedHours) {
        this.serviceName = serviceName;
        this.descriptionOfService = descriptionOfService;
        this.userId = userId;
        this.estimatedHours = estimatedHours;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescriptionOfService() {return descriptionOfService;}

    public void setDescriptionOfService(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getEstimatedHours() { return estimatedHours; }

    public void setEstimatedHours(int estimatedHours) { this.estimatedHours = estimatedHours; }
}
