package net.btcmp.timebank.repository;

import net.btcmp.timebank.entity.ServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail, Long> {

//    vtecie userId, potrebujem matchnut
    @Query(value = "SELECT * FROM service where user_id = :userId", nativeQuery = true)
    List<ServiceDetail> getAllServicesByUserId(Long userId);

////   TODO need REVIEW
//    @Query(value = "select IFNULL(avg (likes),0) AS rating_log  from rating_log where service_id=:serviceId", nativeQuery = true)
//    float getAverageRatingForService(Long serviceId);

//    ----------------------------------------
//    @Query(value = "select IFNULL(avg (stars),0) AS average  from rating where service_id=:jobId", nativeQuery = true)
//    float getAverageRatingForJob(Long jobId);


}
