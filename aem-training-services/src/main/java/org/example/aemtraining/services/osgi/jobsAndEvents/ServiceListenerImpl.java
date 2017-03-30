package org.example.aemtraining.services.osgi.jobsAndEvents;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.service.component.ComponentContext;

/**
 */
@Component(immediate = true)
@Service
public class ServiceListenerImpl implements ServiceListener {
    @Override
    public void serviceChanged(final ServiceEvent event) {
//        System.out.println(event);
    }
    @Activate
    protected void activate(ComponentContext componentContext) {
        componentContext.getBundleContext().addServiceListener(this);
    }


}
