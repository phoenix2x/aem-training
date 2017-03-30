package org.example.aemtraining.services.osgi.resourceprovider;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceProvider;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.SyntheticResource;
import org.apache.sling.jcr.resource.JcrResourceConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 */
@Component
@Service
@Properties({
    @Property(name = ResourceProvider.ROOTS, value = MyTestResourceProvider.ROOT)
})
public class MyTestResourceProvider implements ResourceProvider {
    public static final String ROOT = "test-root";
    public static final String RESOURCE_TYPE = "aem-training/components/provider-test";

    @Override
    public Resource getResource(ResourceResolver resourceResolver, HttpServletRequest request, String path) {
        return new SyntheticResource(resourceResolver, path, RESOURCE_TYPE);
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
