package com.app.sb_practice_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/test")
public class EventController {
    private final EventRepository eventRepository;

    private final EventService eventService;


    @Autowired
    public EventController(EventRepository eventRepository, EventService eventService) {
        this.eventRepository = eventRepository;
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping
    public void registerNewEvent (@RequestBody Event event){
        eventService.addNewEvent(event);
    }

    @DeleteMapping (path = "{eventId}")
    public void deleteEvent(@PathVariable("eventId") Long eventId){
        eventService.deleteEvent(eventId);
    }

    @PutMapping (path = "{eventId}")
    public void updateEvent(@PathVariable("eventId") Long eventId,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String address,
                            @RequestParam(required = false) String city,
                            @RequestParam(required = false) String location){
        eventService.updateEvent(eventId, name, address, city, location);
    }

}
