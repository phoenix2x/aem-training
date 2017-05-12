package org.example.aemtraining.services.osgi.nashorn;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 */
@SlingServlet(paths = "/bin/nashorn")
public class NashornServlet extends SlingSafeMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(NashornServlet.class);

    @Reference
    private TestNashorn testNashorn;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        LOG.error("In doGet");
        PrintWriter writer = response.getWriter();
//        writer.write("qw");
        try {
            writer.write(testNashorn.render());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        LOG.error("MM");

    }
}
