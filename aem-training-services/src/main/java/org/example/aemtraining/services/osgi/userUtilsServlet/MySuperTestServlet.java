package org.example.aemtraining.services.osgi.userUtilsServlet;

import com.day.cq.commons.TidyJSONWriter;
import com.day.cq.wcm.api.Page;
import org.apache.felix.scr.annotations.*;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.SyntheticResource;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.example.aemtraining.services.osgi.getcomponents.ComponentsHelper;
import org.example.aemtraining.services.osgi.utils.NodeHelper;

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
        NodeHelper.doingSmthWithNodeAndProp(request);



        String s = "";

    }
}
