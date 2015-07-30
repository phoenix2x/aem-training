package org.example.aemtraining.services.osgi.userUtilsServlet;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScript;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.ComponentContext;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 */
@SlingServlet(resourceTypes = "sling/servlet/default", selectors = "runscript")
public class RunScriptServlet extends SlingSafeMethodsServlet {


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Resource suffixResource = request.getRequestPathInfo().getSuffixResource();


        if (suffixResource != null) {
            SlingScript slingScript = suffixResource.adaptTo(SlingScript.class);
            if (slingScript != null) {
                SlingBindings slingBindings = new SlingBindings();
                Resource currentResource = request.getResource();
                slingBindings.setResource(currentResource);
                Node currentNode = currentResource.adaptTo(Node.class);
                if (currentNode != null) {
                    slingBindings.put("currentNode", currentNode);
                }
                Session session = currentResource.getResourceResolver().adaptTo(Session.class);
                if (session != null) {
                    slingBindings.put("currentSession", session);
                }


                slingBindings.setRequest(request);
                slingBindings.setResponse(response);
                slingScript.eval(slingBindings);
            }
        }
    }
}
