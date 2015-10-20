package org.example.aemtraining.services.osgi.resourceprovider;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 */

@SlingServlet(resourceTypes = MyTestResourceProvider.RESOURCE_TYPE)
public class WildCardMapedServlet extends SlingSafeMethodsServlet{
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Success");
    }
}
