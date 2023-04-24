package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.LikesDto;
import net.btcmp.timebank.dto.NewLikesDto;
import net.btcmp.timebank.entity.Likes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikesInterface {
        List<Likes> getCountLikes(int page, int size);
        List<Likes> getUserLikes(Long id);
//        BUG: v LikesDto neexistuje premenna userId
        LikesDto userLikes(Long userId);

        Likes saveLike(NewLikesDto like);
        Likes saveHours(NewLikesDto hours);
        Likes saveRatingLog(NewLikesDto likes);

//        void createLogTable(LogDto like);

}
