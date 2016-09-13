package com.springapp.mvc.firststeps;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by sktifa on 13/09/2016.
 */
@Service
public class PixaBayService {

    private static final String pixabayKey = "3295843-da65723c0a6ab289fae9fd0f4";

    public Optional<String> retrievePicture(String query) {
        Optional<String> optional = Optional.empty();
        try {
            RestTemplate restTemplate = new RestTemplate();
            JSONObject jsonObj = new JSONObject(restTemplate.getForObject(buildUrl(query), String.class));
            optional = Optional.ofNullable(jsonObj.getJSONArray("hits").getJSONObject(0).getString("previewURL"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return optional;
    }

    private String buildUrl(String query) {
        return "http://pixabay.com/api/?key=" + pixabayKey + "&q=" + query.replaceAll(" ", "+") + "&image_type=photo&per_page=3";
    }
}
