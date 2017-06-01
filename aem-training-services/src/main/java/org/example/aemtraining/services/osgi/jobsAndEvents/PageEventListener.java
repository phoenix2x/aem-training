package org.example.aemtraining.services.osgi.jobsAndEvents;

import com.day.cq.wcm.api.PageEvent;
import com.day.cq.wcm.api.PageModification;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 */
@Component(immediate = true)
@Service(EventHandler.class)
@Property(name = "event.topics", value = PageEvent.EVENT_TOPIC)
public class PageEventListener implements EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(PageEventListener.class);

    @Override
    public void handleEvent(Event event) {
        /**
         * can cast to PageEvent with additional info
         */
        PageEvent pageEvent = PageEvent.fromEvent(event);
        Iterator<PageModification> pageModifications = pageEvent.getModifications();
        while (pageModifications.hasNext()) {
            LOG.error("page Modifications", pageModifications.next().getType());
        }
    }
}
