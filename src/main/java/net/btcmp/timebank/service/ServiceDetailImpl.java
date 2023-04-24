package net.btcmp.timebank.service;

import net.btcmp.timebank.repository.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetailImpl implements ServiceDetailInterface {

    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    public List<net.btcmp.timebank.entity.ServiceDetail> getAllServicesByUserId(Long userId) {
        return serviceDetailRepository.getAllServicesByUserId(userId);
    }


}
