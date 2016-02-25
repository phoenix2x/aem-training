package org.example.aemtraining.services.osgi.resourceprovider;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceProvider;
import org.apache.sling.api.resource.ResourceResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 */

public class MyAnotherTestResourceProvider implements ResourceProvider {
    @Override
    public Resource getResource(ResourceResolver resourceResolver, HttpServletRequest request, String s) {
        return null;
    }

    @Override
    public Resource getResource(ResourceResolver resourceResolver, String s) {
        return getResource(resourceResolver, null, s);
    }

    @Override
    public Iterator<Resource> listChildren(Resource resource) {
        return null;
    }
}
