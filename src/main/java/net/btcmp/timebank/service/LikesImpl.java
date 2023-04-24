package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.LikesDto;
import net.btcmp.timebank.dto.NewLikesDto;
import net.btcmp.timebank.entity.Likes;
import net.btcmp.timebank.entity.User;
import net.btcmp.timebank.exception.ServiceNotFoundException;
import net.btcmp.timebank.exception.UserNotFoundException;
import net.btcmp.timebank.repository.LikesRepository;
import net.btcmp.timebank.repository.ServiceRepository;
import net.btcmp.timebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class LikesImpl implements LikesInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private LikesRepository likesRepository;


    @Override
    public Likes saveLike(NewLikesDto like) {
        User user = userRepository.findById(like.getLoggedId())
                .orElseThrow(() -> new UserNotFoundException(
                        MessageFormat.format("User with id [{0}] not found", like.getLoggedId())));
        net.btcmp.timebank.entity.Service service = serviceRepository.findById(like.getServiceId())
                .orElseThrow(() -> new ServiceNotFoundException(
                        MessageFormat.format("Service with id [{0}] not found", like.getServiceId())));

        Likes likeToSave = new Likes();
        likeToSave.setServiceId(service.getId());
        likeToSave.setLoggedId(user.getId());
        likeToSave.setHours(like.getHours());
        likeToSave.setRatingLog(like.getRatingLog());

        return likesRepository.save(likeToSave);

    }

    @Override
    public List<Likes> getCountLikes(int page, int size) {
        Page<Likes> likesList = likesRepository.findAll(PageRequest.of(page, size));
        return likesList.stream().toList();

    }

//    @Override
//    public List<Likes> getUserLikes(Long id, int page, int size) {
////        List<Likes> loggedList = likesRepository.findAllById(Collections.singleton(id));
//        List<Likes> loggedList = new
//        List<Likes> loggedList = likesRepository.getUserLikes(id);
//        likesRepository.save(loggedList);
////        Page<Likes> pagedList = loggedList.PageRequest.of(page, size);
//
//        return null;
//    }

    @Override
    public List<Likes> getUserLikes(Long id) {
        return likesRepository.getUserLikes(id);
    }

//    @Override
//    public void createLogTable(LogDto like) {
//
//        Likes likesToSave = new Likes();
//        Likes likes = likesRepository.findById(like.getLoggedId()).get();
//
//        likesToSave.setServiceId();
//
//    }


    @Override
    public LikesDto userLikes(Long serviceId) {
        net.btcmp.timebank.entity.Service service = serviceRepository.findById(serviceId).
                orElseThrow(() -> new ServiceNotFoundException(MessageFormat.format("Service with id [{0}] not found", serviceId)));
        LikesDto likesDto = new LikesDto(likesRepository.userLikes(serviceId));
        return likesDto;

    }

    @Override
    public Likes saveHours(NewLikesDto hours) {
        User user = userRepository.findById(hours.getLoggedId())
                .orElseThrow(() -> new UserNotFoundException(
                        MessageFormat.format("User with id [{0}] not found", hours.getLoggedId())));
        net.btcmp.timebank.entity.Service service = serviceRepository.findById(hours.getServiceId())
                .orElseThrow(() -> new ServiceNotFoundException(
                        MessageFormat.format("Service with id [{0}] not found", hours.getServiceId())));

        Likes hoursToSave = new Likes();
        hoursToSave.setServiceId(service.getId());
        hoursToSave.setLoggedId(user.getId());
        hoursToSave.setHours(hours.getHours());

        return likesRepository.save(hoursToSave);
    }

    @Override
    public Likes saveRatingLog(NewLikesDto likes) {
        User user = userRepository.findById(likes.getLoggedId())
                .orElseThrow(() -> new UserNotFoundException(
                        MessageFormat.format("User with id [{0}] not found", likes.getLoggedId())));
        net.btcmp.timebank.entity.Service service = serviceRepository.findById(likes.getServiceId())
                .orElseThrow(() -> new ServiceNotFoundException(
                        MessageFormat.format("Service with id [{0}] not found", likes.getServiceId())));

        Likes ratingLogToSave = new Likes();
        ratingLogToSave.setServiceId(service.getId());
        ratingLogToSave.setLoggedId(user.getId());
        ratingLogToSave.setRatingLog(likes.getRatingLog());

        return likesRepository.save(ratingLogToSave);
    }

}

