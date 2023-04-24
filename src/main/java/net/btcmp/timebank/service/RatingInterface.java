package net.btcmp.timebank.service;

import net.btcmp.timebank.dto.RatingDto;
import org.springframework.stereotype.Service;

@Service
public interface RatingInterface {

    Float getAverage(Long id);

    void saveRating(RatingDto rating);

}
