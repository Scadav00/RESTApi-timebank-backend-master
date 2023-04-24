package net.btcmp.timebank.repository;

import net.btcmp.timebank.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

//    @Query(value = "select IFNULL(avg (stars),0) AS average  from rating where service_id=:serviceId", nativeQuery = true)
//    float getAverageRatingForService(Long serviceId);

//
//    @Query(value = "select IFNULL(avg (stars),0) AS average  from rating where service_id=:jobId", nativeQuery = true)
//    float getAverageRatingForJob(Long jobId);


}
