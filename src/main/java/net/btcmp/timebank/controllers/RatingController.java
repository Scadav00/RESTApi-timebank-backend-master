package net.btcmp.timebank.controllers;

import net.btcmp.timebank.dto.RatingDto;
import net.btcmp.timebank.repository.RatingRepository;
import net.btcmp.timebank.service.RatingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    public final RatingInterface ratingInterface;

    public RatingController(RatingInterface ratingInterface) {
        this.ratingInterface = ratingInterface;
    }

    //    id represents serviceID! - getAverageRating
    @GetMapping("/services/{id}/rating")
    public float getRating(@PathVariable Long id){
        return ratingInterface.getAverage(id);
    }

    @PostMapping("/service/rating")
    public void saveRating(@RequestBody RatingDto rating){
        ratingInterface.saveRating(rating);
    }



}
