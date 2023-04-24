package net.btcmp.timebank.repository;

import net.btcmp.timebank.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Long>{
//    instead of swiring all columns used *

//    @Query( value = "SELECT likes.* FROM likes inner join service  on likes.service_id= service.id inner join user u on service.user_id = u.id where service.id = :serviceId", nativeQuery = true)
//    @Query( value = "SELECT likes.* FROM likes inner join user  on likes.user_id= user.id inner join service s on user.service_id = u.id where service.id = :userId", nativeQuery = true)
    @Query(value = "SELECT * FROM likes where user_id = :userId", nativeQuery = true)
    List<Likes> getUserLikes(Long userId);

//    @Query( value = "SELECT likes.* FROM likes inner join service  on likes.service_id= service.id inner join user u on service.user_id = u.id where service.id = :serviceId", nativeQuery = true)
//    List<Likes> getUserLikes(Long serviceId);

//    @Query( value = "SELECT likes.id, likes.like_date,likes.service_id,likes.user_id FROM likes inner join service  on likes.service_id= service.id inner join user u on service.user_id = u.id where service.id = :serviceId", nativeQuery = true)
//    List<Likes> getUserLikes(Long serviceId);

    @Query(value = "SELECT COUNT(*) FROM likes inner join service  on likes.service_id= service.id inner join user u on service.user_id = u.id where service.id = :serviceId", nativeQuery = true)
    Integer userLikes(Long serviceId);

    @Query(value = "select IFNULL(avg(rating_log),0) AS average  from likes where service_id=:serviceId", nativeQuery = true)
//    @Query(value = "select avg(rating_log) AS average  from likes where service_id=:serviceId", nativeQuery = true)
    Float getAverageRatingForService(Long serviceId);

//    @Query(value = "select IFNULL(avg (stars),0) AS average  from rating where service_id=:jobId", nativeQuery = true)
//    float getAverageRatingForJob(Long jobId);



}
