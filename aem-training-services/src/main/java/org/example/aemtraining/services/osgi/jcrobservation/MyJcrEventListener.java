package org.example.aemtraining.services.osgi.jcrobservation;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Workspace;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

/**
 * test
 */
@Component(immediate = true)
@Service
public class MyJcrEventListener implements EventListener{

    @Reference
    private SlingRepository slingRepository;

    private Session adminSession;

    @Override
    public void onEvent(final EventIterator events) {
        System.out.println("w");
    }

    @Activate
    protected void activate(ComponentContext context) {
        try {
            adminSession = slingRepository.loginAdministrative(null);
            adminSession.getWorkspace().getObservationManager().addEventListener(this, Event.NODE_ADDED, "/content", true, null, null, false);
        } catch (RepositoryException e) {

        }
    }

    @Deactivate
    protected void deactivate(ComponentContext inContext) {
        try {
            adminSession.getWorkspace().getObservationManager().removeEventListener(this);
        } catch (RepositoryException e) {
        } finally {
            if(adminSession !=null && adminSession.isLive()) {
                adminSession.logout();
            }
        }
    }

}
