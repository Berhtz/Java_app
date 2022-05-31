package com.stat.app.AppModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {
    
    public List<App> findAllByUserEmail(String userEmail);
}