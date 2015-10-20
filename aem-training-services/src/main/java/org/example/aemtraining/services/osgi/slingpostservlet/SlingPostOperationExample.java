package org.example.aemtraining.services.osgi.slingpostservlet;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.servlets.post.PostOperation;
import org.apache.sling.servlets.post.PostResponse;
import org.apache.sling.servlets.post.SlingPostProcessor;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 */

@Component(immediate=true)
@Service
@Property(name=PostOperation.PROP_OPERATION_NAME, value="test:SlingPostOperationExample")
public class SlingPostOperationExample implements PostOperation {
    public void run(SlingHttpServletRequest request, PostResponse response, SlingPostProcessor[] processors) {
        final Resource r = request.getResource();
        final Node n = r.adaptTo(Node.class);
        try {
            response.setPath(r.getPath());
            response.setTitle("Content modified by " + getClass().getSimpleName());
            n.setProperty(getClass().getName(), "Operation was applied to " + n.getPath());
            n.getSession().save();
        } catch(RepositoryException re) {
            throw new SlingException(getClass().getSimpleName() + " failed", re);
        }
    }
}
