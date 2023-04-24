package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.NewServiceDto;
import net.btcmp.timebank.entity.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceInterface {
    List<Service> getAllServices(int page, int size);

    Service getService(Long id);
    Service saveService(NewServiceDto service);

    ResponseEntity<Service> updateDescription(Service service, Long id);
}



