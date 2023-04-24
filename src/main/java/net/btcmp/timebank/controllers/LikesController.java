package net.btcmp.timebank.controllers;

import net.btcmp.timebank.dto.LikesDto;
import net.btcmp.timebank.dto.NewLikesDto;
import net.btcmp.timebank.entity.Likes;
import net.btcmp.timebank.service.LikesInterface;
import net.btcmp.timebank.service.RatingInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LikesController {
    public final LikesInterface likesInterface;
    public final RatingInterface ratingInterface;

    public LikesController(LikesInterface likesInterface, RatingInterface ratingInterface) {
        this.likesInterface = likesInterface;
        this.ratingInterface = ratingInterface;

    }

//    id podla service vyhody vsecky logy z tabulky  - musi sa zmenit na userId
    @GetMapping("/likes/{id}")
    public List<Likes> getUserLikes(@PathVariable Long id){
        return likesInterface.getUserLikes(id);
    }

//    @PostMapping("/likes/logs")
//    public void createLogTable(@RequestBody LogDto like){
//        likesInterface.createLogTable(like);
//    }


    @GetMapping("/likes")
    public List<Likes> getLikes(@RequestParam(defaultValue = "0", required = false) int page,
                                @RequestParam(defaultValue = "20", required = false) int size){
        return likesInterface.getCountLikes(page, size);
    }

// servisId a vyhodi pocet zaznamov podla servisi
    @GetMapping("/user/{id}/likes")
    public LikesDto userCountLikes(@PathVariable Long id){
        return likesInterface.userLikes(id);
    }

//--------------------------------------------LOGS//
    //    prida hours na null a rating na null

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.CREATED)
    public Likes saveLike(@RequestBody @Valid NewLikesDto like){
        return likesInterface.saveLike(like);
    }

//    prida hours a null na rating
    @PostMapping("/hours")
    @ResponseStatus(HttpStatus.CREATED)
//    Likes creates hours instead of "likes"
    public Likes saveHours(@RequestBody @Valid NewLikesDto hours){
        return likesInterface.saveHours(hours);
    }

    //    prida rating a null na hours
    @PostMapping("/rating")
    @ResponseStatus(HttpStatus.CREATED)
//    Likes creates rating instead of "likes"
//    pushing entity likes, not variable ratingLog
    public Likes saveRating(@RequestBody @Valid NewLikesDto likes){
        return likesInterface.saveRatingLog(likes);
    }


}
