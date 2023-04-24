package net.btcmp.timebank.repository;

import net.btcmp.timebank.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
//    @Query(value = "SELECT estimated_hours FROM service where user_id = :userId", nativeQuery = true)
//    Service getUsersHours(Long userId);


}