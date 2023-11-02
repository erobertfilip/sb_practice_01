package com.app.sb_practice_01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT e.id FROM Event e")
    ArrayList<String> getAllEventIds();

    @Query(value = "SELECT e.name FROM Event e")
    ArrayList<String> getAllEventNames();

    Optional<Event> findEventById(Long id);
}
