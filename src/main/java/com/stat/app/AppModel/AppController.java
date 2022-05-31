package com.stat.app.AppModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    AppRepository appRepository;
    
    @GetMapping("/create_app")
    public String openApps(Model model, Authentication authentication) {
        model.addAttribute("app", new App());
        return "create_app";
    }

    @PostMapping("/create_app")
    public String processRegister(App app, Model model, Authentication authentication) {
        model.addAttribute("app", app);
        app.setUserEmail(authentication.getName());
        appRepository.save(app);
        List<App> listApps = appRepository.findAllByUserEmail(authentication.getName());
        model.addAttribute("listApps", listApps);
        return "apps";
    }

    @GetMapping("/apps")
    public String viewAppListPage(Model model, Authentication authentication) {

        List<App> listApps = appRepository.findAllByUserEmail(authentication.getName());
        model.addAttribute("listApps", listApps);
        return "apps";
    }
}


