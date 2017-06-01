package org.example.aemtraining.services.osgi.jobsAndEvents;

import org.apache.commons.lang.BooleanUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import java.util.HashMap;

/**
 * test2
 */
@Component(immediate = true)
public class EventPublisher {

    @Reference
    private EventAdmin eventAdmin;

    @Activate
    protected void activate(ComponentContext componentContext) {
        HashMap<String, Object> props = new HashMap<>();
        /**
         * to distribute event in cluster set this prop
         */
        props.put("event.distribute", Boolean.TRUE);
        Event event = new Event("org/eaxmple/testevent", props);

        /**
         * Synchronous
         */
        eventAdmin.sendEvent(event);
        /**
         * Async
         */
        eventAdmin.postEvent(event);
    }
}
