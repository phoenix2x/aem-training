package org.example.aemtraining.services.osgi.userUtilsServlet;

import com.day.cq.commons.TidyJSONWriter;
import org.apache.felix.scr.annotations.*;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.example.aemtraining.services.osgi.getcomponents.ComponentsHelper;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Dictionary;

/**
 */
@SlingServlet(paths = {"/bin/mytestservlet"}, metatype = true)
@Properties({
        @Property(name = "testPR", value = "testVal")
})
public class MySuperTestServlet extends SlingAllMethodsServlet {

    @Reference
    private ComponentsHelper componentsHelper;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        Dictionary props = componentsHelper.getComponentsProperties(this.getClass().getName());
        Dictionary props1 = componentsHelper.getComponentPropsUsingScr(this.getClass().getName());


        String s = "";

    }
}
