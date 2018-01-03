package org.example.aemtraining.services.osgi.userUtilsServlet;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 */
@SlingServlet(paths = "/bin/test-servlet")
public class TestServlet extends SlingAllMethodsServlet {
//
//    @Reference
//    private Videos videos;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("asd");
    }
}
