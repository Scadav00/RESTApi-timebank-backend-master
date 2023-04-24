package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.NewServiceDto;
import net.btcmp.timebank.entity.Service;
import net.btcmp.timebank.exception.ServiceNotFoundException;
import net.btcmp.timebank.exception.UserNotFoundException;
import net.btcmp.timebank.repository.ServiceRepository;
import net.btcmp.timebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.text.MessageFormat;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    UserRepository userRepository;

    private final ServiceRepository serviceRepository;

    public ServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Service> getAllServices(int page, int size) {
        Page<Service> servicesList = serviceRepository.findAll(PageRequest.of(page, size));

        return servicesList.stream().toList();
    }


    @Override
    public Service getService(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException(
                        MessageFormat.format("Service with id [{0}] not found", id)));
    }


    @Override
    public Service saveService(NewServiceDto service) {
        Service serviceToSave = new Service();
        serviceToSave.setServiceName(service.getServiceName());
        serviceToSave.setDescriptionOfService(service.getDescriptionOfService());
        serviceToSave.setEstimatedHours(service.getEstimatedHours());
        serviceToSave.setUser(
//                hladame podla idcka pouzivatela
                userRepository.findById(service.getUserId())
                        .orElseThrow(() -> new UserNotFoundException(
                                MessageFormat.format("User with id [{0}] not found.", service.getUserId()))

                        ));
        return serviceRepository.save(serviceToSave);
    }

    @Override
    public ResponseEntity<Service> updateDescription(Service service, Long id) {
//prob need @query for userId @ review
        Service updateDescription = serviceRepository.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Service with :id was not found" + id));

        updateDescription.setServiceName(service.getServiceName());
        updateDescription.setDescriptionOfService(service.getDescriptionOfService());
        updateDescription.setEstimatedHours(service.getEstimatedHours());

        serviceRepository.save(updateDescription);

        return ResponseEntity.ok(updateDescription);
    }

}
