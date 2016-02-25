package org.example.aemtraining.services.osgi.slingpostprocessors;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.servlets.post.Modification;
import org.apache.sling.servlets.post.SlingPostProcessor;

import java.util.List;

/**
 */
@Component(immediate = true)
@Service(SlingPostProcessor.class)
public class PostProcessorTest implements SlingPostProcessor {
    @Override
    public void process(final SlingHttpServletRequest slingHttpServletRequest, final List<Modification> list) throws Exception {
        System.out.println("q");
    }
}
