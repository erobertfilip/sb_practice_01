package com.app.sb_practice_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        boolean exists = eventRepository.existsById(eventId);
        if(!exists){
            throw new IllegalStateException("Event with ID " + eventId + "does not exist.");
        }else {
            eventRepository.deleteById(eventId);
        }

    }

    @Transactional
    public void updateEvent(Long eventId, String name, String address, String city, String location) {

    }
}
