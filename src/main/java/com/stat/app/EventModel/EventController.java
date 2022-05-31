package com.stat.app.EventModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    @GetMapping("/show_events")
    public String eventInit(Model model, Event event, Authentication authentication)
            throws IOException {

        model.addAttribute("event", new Event());
        model.addAttribute("event", event);

        JSONObject json = readJsonFromUrl("http://localhost:8080/actuator/httptrace");

        for (Integer i = 0; i<json.names().length(); i++) {
            if (json.getJSONArray("traces").getJSONObject(i).getJSONObject("principal").getString("name")
                    .equals(authentication.getName())) {

                event.setEventPrincipal(
                        json.getJSONArray("traces").getJSONObject(i).getJSONObject("principal").getString("name"));
                event.setEventUri(
                        json.getJSONArray("traces").getJSONObject(i).getJSONObject("request").getString("uri"));
                event.setEventMethod(
                        json.getJSONArray("traces").getJSONObject(i).getJSONObject("request").getString("method"));
                event.setEventStatus(
                        json.getJSONArray("traces").getJSONObject(i).getJSONObject("response").getInt("status"));
                eventRepository.save(event);
            }
        }

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