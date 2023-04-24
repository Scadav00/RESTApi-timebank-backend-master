package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.RatingDto;
import net.btcmp.timebank.entity.Rating;
import net.btcmp.timebank.repository.LikesRepository;
import net.btcmp.timebank.repository.RatingRepository;
import net.btcmp.timebank.repository.ServiceRepository;
import net.btcmp.timebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingImpl implements RatingInterface {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Float getAverage(Long serviceId) {
        return likesRepository.getAverageRatingForService(serviceId);
//        return null;
    }

//    *
    @Override
    public void saveRating(RatingDto rating) {

        Rating ratingToSave = new Rating();
        net.btcmp.timebank.entity.Service service = serviceRepository.findById(rating.getServiceId()).get();

        ratingToSave.setServiceId(service);
        ratingToSave.setUserId(userRepository.findById(rating.getUserId()).get());
        ratingToSave.setStars(rating.getStars());

        ratingRepository.save(ratingToSave);

        Float average = getAverage(rating.getServiceId());
        Double averageDouble = average != null ? average.doubleValue() : null;
        service.setRating(averageDouble);
        serviceRepository.save(service);
    }

//    ---------------------------

//    @Override
//    public void saveRating(RatingDto rating) {
//
//        Rating ratingToSave = new Rating();
//        Job job = jobRepository.findById(rating.getServiceId()).get();
//
//        ratingToSave.setServiceId(job);
//        ratingToSave.setUserId(userRepository.findById(rating.getUserId()).get());
//        ratingToSave.setStars(rating.getStars());
//
//        ratingRepository.save(ratingToSave);
//
//
//        job.setRating(getAverage(rating.getServiceId()));
//        jobRepository.save(job);
//
//    }



}
