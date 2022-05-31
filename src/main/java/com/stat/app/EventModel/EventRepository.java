package com.stat.app.EventModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    
    public List<Event> findAllByEventMethod(String eventMethod);
}