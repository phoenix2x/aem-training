package org.example.aemtraining.services.osgi.userUtilsServlet;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.Group;
import org.apache.jackrabbit.api.security.user.User;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 */
//@SlingServlet(paths="/bin/userutils")
//@SlingServlet(resourceTypes = "sling/servlet/default")
@SlingServlet(resourceTypes = "aem-training/components/examplepage", selectors = "test")
public class UserUtilsServlet extends SlingSafeMethodsServlet {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Session session = resourceResolver.adaptTo(Session.class);
        UserManager userManager = resourceResolver.adaptTo(UserManager.class);

        boolean isAdmin = false;
        try {
            Authorizable authorizableUser = userManager.getAuthorizable(session.getUserID());
//            Authorizable authorizableGroup = userManager.getAuthorizable("administrators");
            isAdmin = ((User)authorizableUser).isAdmin();
//            if (authorizableGroup != null && authorizableUser != null && authorizableGroup.isGroup()) {
//                isAdmin = ((Group)authorizableGroup).isMember(userManager.getAuthorizable(authorizableUser.getPrincipal().getName()));
//            }
        } catch (RepositoryException e) {
            LOG.error("err", e);
        }
        writeJson(isAdmin, response);
    }

    private void writeJson(boolean isAdmin, SlingHttpServletResponse response) {
        JsonFactory jsonFactory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = null;
        try {
            jsonGenerator = jsonFactory.createGenerator(response.getWriter());
            objectMapper.writeValue(jsonGenerator, ImmutableMap.of("isAdmin", isAdmin));
        } catch (IOException e) {

        }

    }
}
