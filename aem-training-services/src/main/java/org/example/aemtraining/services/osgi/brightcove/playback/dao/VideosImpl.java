package org.example.aemtraining.services.osgi.brightcove.playback.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 */
@Component(immediate = true)
@Service(Videos.class)
public class VideosImpl implements Videos {

    private static final String URL = "https://edge.api.brightcove.com/playback/v1/accounts/1078702682/videos";
    private static final Logger LOGGER = LoggerFactory.getLogger(VideosImpl.class);
    private static final String AUTH_HEADER = "BCOV-Policy BCpkADawqM2sRB1pgkL6o6VSPeM0b5LJwOQCFD1-U-Q1JkuvmZCgA0LbeCwfMSyBihXj8BtuKEzsIZq9YbODPzT0Khrs-zxXRc76Mq09SfFmoXf-3B5O2jEUGIOCKsFLQds4lwt1NyU5iMqJ";
//
    @Override
    public Map getVideos(String query) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .header("Authorization", AUTH_HEADER)
                .build();
        Map responseValue = null;
        try {
            responseValue = new ObjectMapper()
                    .reader()
                    .withType(Map.class)
                    .readValue(client.newCall(request).execute().body().string());
        } catch (IOException e) {
            LOGGER.error("Error fetching videos", e);
        }

        return responseValue;
//        return Maps.newHashMap();
    }
}
