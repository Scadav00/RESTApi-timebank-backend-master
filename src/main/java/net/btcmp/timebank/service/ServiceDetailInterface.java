package net.btcmp.timebank.service;

import net.btcmp.timebank.entity.ServiceDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceDetailInterface {

    List<ServiceDetail> getAllServicesByUserId(Long userId);
//    float getAverage(Long id);

}
