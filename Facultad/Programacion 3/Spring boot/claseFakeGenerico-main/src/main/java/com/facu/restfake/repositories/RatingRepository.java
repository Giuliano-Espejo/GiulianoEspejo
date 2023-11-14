package com.facu.restfake.repositories;



import com.facu.restfake.entities.Rating;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends BaseRepository<Rating,Long> {
}
