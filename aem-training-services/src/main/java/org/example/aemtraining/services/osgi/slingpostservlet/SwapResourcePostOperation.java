package org.example.aemtraining.services.osgi.slingpostservlet;

import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.servlets.post.PostOperation;
import org.apache.sling.servlets.post.PostResponse;
import org.apache.sling.servlets.post.SlingPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;

/**
 */

@Component(immediate = true)
@Service
@Property(name = PostOperation.PROP_OPERATION_NAME, value = "swap")
public class SwapResourcePostOperation implements PostOperation {
    private final static Logger itsLogger = LoggerFactory.getLogger(SwapResourcePostOperation.class);
    private static final String DEFAULT_DAYS_NUMBER = "30";
    private static final String DAYS_NUMBER_PROP = "daysNumber";
    private static final String ACTION_UP = "up";
    private static final String ACTION_PARAM = "action";
    private static final String HTML_EXTENSION = ".html";


    @Override
    public void run(SlingHttpServletRequest request, PostResponse response, SlingPostProcessor[] slingPostProcessors) {
        Resource movingResource = request.getResource();
//        PageManager pageManager =  movingResource.getResourceResolver().adaptTo(PageManager.class);

        ValueMap parentProps = movingResource.getParent().adaptTo(ValueMap.class);
        int daysNumber = Integer.parseInt(parentProps.get(DAYS_NUMBER_PROP, DEFAULT_DAYS_NUMBER));
        String action = request.getParameter(ACTION_PARAM);
//        String action = request.getRequestPathInfo().getSelectors()[1];
        try {
            if (ACTION_UP.equals(action)) {
                ItemMoveUtil.moveUp(movingResource, daysNumber);
            } else {
                ItemMoveUtil.moveDown(movingResource, daysNumber);
            }
        } catch (RepositoryException e) {
            itsLogger.error("javax.jcr.RepositoryException", e);
        } catch (WCMException e) {
            itsLogger.error("com.day.cq.wcm.api.WCMException", e);
        }

//        response.sendRedirect(pageManager.getContainingPage(movingResource.getPath()).getPath() + HTML_EXTENSION);
    }
}
