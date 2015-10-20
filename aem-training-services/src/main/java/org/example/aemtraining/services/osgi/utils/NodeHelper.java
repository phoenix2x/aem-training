package org.example.aemtraining.services.osgi.utils;

import org.apache.sling.api.SlingHttpServletRequest;

import javax.jcr.Session;

/**
 */

public class NodeHelper {

    public static final void doingSmthWithNodeAndProp(SlingHttpServletRequest request) {
        Session session = request.getResourceResolver().adaptTo(Session.class);
    }
}
