package net.btcmp.timebank.controllers;


import net.btcmp.timebank.dto.NewServiceDto;
import net.btcmp.timebank.entity.Service;
import net.btcmp.timebank.repository.ServiceRepository;
import net.btcmp.timebank.repository.UserRepository;
import net.btcmp.timebank.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserRepository userRepository;
    private ServiceInterface serviceInterface;

    public ServiceController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

//    there's limit to show set to 20
    @GetMapping("/services")
    public List<Service> getAllServices(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "20", required = false) int size){
        return serviceInterface.getAllServices(page, size);
    }

    //getServiceByServiceId - saveService
    @GetMapping("/service/{id}")
    public Service getService(@PathVariable Long id){
        return serviceInterface.getService(id);
    }

        //deleteServiceByServiceId
//    @DeleteMapping("/services/{id}") - HOTFIX
//    potom mozno
    @RequestMapping(value="/service/{id}", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        serviceRepository.deleteById(id);
    }

//    addNewService - REVIEW need HOTFIX
    @PostMapping("/service")
    @ResponseStatus(HttpStatus.CREATED)
    public Service newService(@Valid @RequestBody NewServiceDto service) {
        return serviceInterface.saveService(service);
    }

    //    update description on userId, for what service??? oneToMany
//    userId drop! serviceId primary key unique

    @PutMapping("/service/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Service> updateDescription(@RequestBody Service service, @PathVariable Long id){
        return serviceInterface.updateDescription(service, id);
    }


}
