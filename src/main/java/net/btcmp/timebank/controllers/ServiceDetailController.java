package net.btcmp.timebank.controllers;

import net.btcmp.timebank.entity.ServiceDetail;
import net.btcmp.timebank.repository.ServiceDetailRepository;
import net.btcmp.timebank.service.RatingInterface;
import net.btcmp.timebank.service.ServiceDetailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceDetailController {

    @Autowired
    ServiceDetailRepository serviceDetailRepository;

    @Autowired
    ServiceDetailInterface serviceDetailInterface;

    @Autowired
    RatingInterface ratingInterface;

    @GetMapping("/user/services/{userId}")
    public List<ServiceDetail> getAllServicesByUserId(@PathVariable Long userId){
        return serviceDetailInterface.getAllServicesByUserId(userId);
    }

//   TODO musi TIECT iba id a cez ALTER TABLE (schema.sql) SA TO PREPOJI ABY TO BAVILO V @QUERY

//    @GetMapping("/services/{id}/rating")
//    public float getRating(@PathVariable Long id){
//        return ratingInterface.getAverage(id);
//    }

//    @GetMapping("/jobs/{id}/rating")
//    public float getRating(@PathVariable Long id){
//        return ratingService.getAverage(id);
//    }

}
