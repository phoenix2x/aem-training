package org.example.aemtraining.services.osgi.jobsAndEvents;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.JobManager;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 */
@Component(immediate = true)
@Service
@Properties({
    @Property(name = EventConstants.EVENT_TOPIC, value = SlingConstants.TOPIC_RESOURCE_ADDED),
    @Property(name = EventConstants.EVENT_FILTER, value = "(&(path=/etc/dam/tmp/*)(resourceType=nt:file))")
})
public class TestEventHandler implements EventHandler {

    public static final String JOB_TOPIC = "com/sling/eventing/dropbox/job";

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Reference
    private JobManager jobManager;

    @Reference
    private ResourceResolverFactory resolverFactory;

    @Override
    public void handleEvent(Event event) {
        try {
            String resourcePath = (String) event.getProperty(SlingConstants.PROPERTY_PATH);

            LOG.info(StringUtils.substringAfterLast(resourcePath, "/"));
            Map<String, Object> props = new HashMap<String, Object>();
            props.put("path", resourcePath);
            String[] resourceAttributes = (String[]) event.getProperty("resourceAddedAttributes");
            List<String> resourceAttributesList = Arrays.asList(resourceAttributes);
            String mimeType = "def";
            if (resourceAttributesList.indexOf("jcr:mimeType") != -1) {
                props.put("mimType", "true");
//                    mimeType = "true";
            } else {
                props.put("mimType", "false");
//                    mimeType = "false";
            }
            Job job = jobManager.addJob(JOB_TOPIC, resourcePath + "mime" + mimeType, props);

            if (job != null) {
                LOG.info("job added for " + StringUtils.substringAfterLast(resourcePath, "/"));
            } else {
                LOG.info("job not added " + StringUtils.substringAfterLast(resourcePath, "/"));
            }
        } catch (Exception e) {
            LOG.error("er", e);
        }

    }
}
