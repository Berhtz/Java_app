package com.stat.app.EventModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraphController {

    @Autowired
    EventRepository eventRepository;
    
    @GetMapping("/graph")
    public String viewHomePage(Model model) {
        
        Map<String, Integer> data = new LinkedHashMap<String, Integer>();

        List<Event> getMethodList = eventRepository.findAllByEventMethod("GET");
        List<Event> postMethodList = eventRepository.findAllByEventMethod("POST");

		data.put("GET", getMethodList.size());
		data.put("POST", postMethodList.size());
		model.addAttribute("keySet", data.keySet());
		model.addAttribute("values", data.values());
        return "graph";
    }

}
