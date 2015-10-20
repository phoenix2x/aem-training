package org.example.aemtraining.services.osgi.slingpostservlet;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.Calendar;

/**
 * Created by Ihar_Zhavarankau on 15/09/2015.
 */
public class ItemMoveUtil {
    public static final String SEPARATOR = "_";
    public static final String TEMP_NODE_INDEX = "temp";

    public static void moveUp(Resource resource, int totalNumber) throws RepositoryException, WCMException {
        move(resource, -1, totalNumber);
    }

    public static void moveDown(Resource resource, int totalNumber) throws RepositoryException, WCMException {
        move(resource, 1, totalNumber);
    }

    public static void move(Resource resource, int indexDelta, int totalNumber) throws RepositoryException, WCMException {
        Session session = resource.getResourceResolver().adaptTo(Session.class);

        String currentPath = resource.getPath();

        int currentIndex = Integer.parseInt(StringUtils.substringAfterLast(currentPath, SEPARATOR));
        int newIndex = getNewIndex(currentIndex, indexDelta, totalNumber);

        String newPath = createPath(currentPath, newIndex);

        if (session.nodeExists(newPath)) {
            swap(currentPath, newPath, session);
        } else {
            session.move(currentPath, newPath);
        }
        touchPage(resource);
        session.save();
    }

    private static void swap(String currentPath, String newPath, Session session) throws RepositoryException {
        String tempPath = createPath(newPath, TEMP_NODE_INDEX);
        session.move(newPath, tempPath);
        session.move(currentPath, newPath);
        session.move(tempPath, currentPath);
    }

    private static int getNewIndex(int currentIndex, int indexDelta, int totalNumber) {
        int newIndex = currentIndex + indexDelta;
        if (newIndex <= 0) {
            newIndex = totalNumber - newIndex;
        } else if(newIndex > totalNumber){
            newIndex = newIndex - totalNumber;
        }
        return newIndex;
    }

    private static String createPath(String oldPath, Object newIndex) {
        return StringUtils.substringBeforeLast(oldPath, SEPARATOR) + SEPARATOR + newIndex;
    }

    public static void touchPage(Resource resource) throws WCMException {
        PageManager thePageManager = resource.getResourceResolver().adaptTo(PageManager.class);
        Page containingPage = thePageManager.getContainingPage(resource);
        if (containingPage != null) {
            Node thePageNode = containingPage.adaptTo(Node.class);
            thePageManager.touch(thePageNode, true, Calendar.getInstance(), false);
        }
    }
}
