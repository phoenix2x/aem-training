package org.example.aemtraining.services.osgi.brightcove.playback;


import org.example.aemtraining.services.osgi.brightcove.models.Video;

import java.util.Collections;

/**
 */

public class SearchImpl implements Search {
    public Iterable<Video> getVideos(String query) {
        return Collections.emptyList();
    }

}
