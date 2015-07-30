package org.example.aemtraining.services.osgi.jobs;

import com.day.cq.commons.jcr.JcrUtil;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.*;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NodeType;
import javax.jcr.version.VersionException;
import java.util.HashMap;

/**
 */
@Component(immediate = true)
@Service
@Property(name = JobConsumer.PROPERTY_TOPICS, value = TestEventHandler.JOB_TOPIC)
public class TestJobConsumer implements JobConsumer {

    public enum MimeType {
        IMAGE("image/png", "/etc/dam/test/images"),
        OTHER("", "/etc/dam/test/other");
        private final String type;
        private final String path;

        MimeType(String type, String path) {
            this.type = type;
            this.path = path;
        }
        public String type() {
            return type;
        }
        public String path() {
            return path;
        }

        public static MimeType of(String inType) {
            for (MimeType type: MimeType.values()) {
                if (type.type.equalsIgnoreCase((inType))) {
                    return type;
                }
            }
            return OTHER;
        }

        @Override
        public String toString() {
            return super.toString() + "; " + type + "; " + path;
        }
    }

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Reference
    private ResourceResolverFactory resolverFactory;

    @Reference
    private SlingRepository repository;

    @Override
    public JobResult process(Job job) {
        LOG.info("in process");
        ResourceResolver resourceResolver = null;
        try {
            resourceResolver = resolverFactory.getAdministrativeResourceResolver(null);
            String resourcePath = (String) job.getProperty("path");
            String resourceName = StringUtils.substringAfterLast(resourcePath, "/");
            Resource resource = resourceResolver.getResource(resourcePath);
            if (resource.isResourceType("nt:file")) {
                MimeType mimeType = MimeType.of(resource.getResourceMetadata().getContentType());
                String destDir = mimeType.path();


                // Resource move can resolve name conflict(add number at the end)
                PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
                if (pageManager != null) {
                    ResourceUtil.getOrCreateResource(resourceResolver, destDir, new HashMap<String, Object>(), null, true);
                    pageManager.move(resource, destDir + "/" + resourceName, null, false, true, null);
                }

                // Node move cant resolve name conflicts
//                Session adminSession = resourceResolver.adaptTo(Session.class);
//                if (adminSession != null) {
//                    Node destNode = JcrUtil.createPath(destDir, NodeType.NT_FOLDER, adminSession);
//                    adminSession.move(resourcePath, destNode.getPath() + "/" + resourceName);
//                    adminSession.save();
//                    LOG.info("success" + resourceName);
//                } else {
//                    LOG.info("session is null");
//                }

            }
        } catch (Throwable e) {
            LOG.error("error move", e);
        } finally {
            if (resourceResolver != null && resourceResolver.isLive()) {
                resourceResolver.close();
            }
        }
        return JobResult.OK;
    }
}
