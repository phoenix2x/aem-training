package org.example.aemtraining.services.osgi.userUtilsServlet;

import com.day.cq.commons.TidyJsonItemWriter;
import com.google.common.collect.Sets;
import org.apache.felix.scr.annotations.*;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.*;

/**
 */
@SlingServlet(resourceTypes = "sling/servlet/default", selectors = "stringify", metatype = true)
public class JsonServlet extends SlingSafeMethodsServlet {
    @Property(value = {"jcr:primaryType"}, unbounded = PropertyUnbounded.ARRAY)
    private static final String PROPERTY_NAMES_TO_IGNORE = "propertyNamesToIgnore";

    private static final String RESPONSE_CONTENT_TYPE = "application/json";
    private Set<String> propertyNamesToIgnore;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());



    @Activate
    protected void activate(ComponentContext context) {
        LOG.info(this.getClass().getName() + " activate BEGIN");

        Dictionary properties = context.getProperties();
        propertyNamesToIgnore = toSet(properties.get(PROPERTY_NAMES_TO_IGNORE));

        LOG.info(this.getClass().getName() + " activate END");
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Node currentNode = request.getResource().adaptTo(Node.class);
        if (currentNode != null) {
            TidyJsonItemWriter jsonItemWriter = new TidyJsonItemWriter(propertyNamesToIgnore);
            try {
                response.setContentType(RESPONSE_CONTENT_TYPE);
                jsonItemWriter.dump(currentNode, response.getWriter(), -1);
            } catch (RepositoryException e) {
                LOG.error("Error", e);
            } catch (JSONException e) {
                LOG.error("Error", e);
            }
        }
    }

    private Set<String> toSet(Object inObject) {
        if (inObject.getClass().isArray()) {
            return Sets.newHashSet((String[])inObject);
        } else {
            return Sets.newHashSet(inObject.toString());
        }
    }
}
