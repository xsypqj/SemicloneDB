package com.semiclone.springboot.domain.screen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    @Query("SELECT id FROM Screen WHERE name = ?1 AND cinemaId = ?2")
    List<Long> findIdByNameAndCinemaId(String name, Long cinemaId);

    Screen findOneById(Long screenId);
    
    @Query("SELECT cinemaId FROM Screen WHERE id = ?1")
    Long findCinemaIdById(Long id);

    @Query("SELECT id FROM Screen WHERE cinemaId = ?1 ORDER BY id ASC")
    List<Long> findIdByCinemaId(Long cinemaId);

    @Query("SELECT id FROM Screen WHERE cinemaId = ?1 AND name = ?2")
    Long findIdByCinemaIdAndName(Long cinemaId, String name);

}//end of interface