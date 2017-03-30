package org.example.aemtraining.services.osgi.sessionlistener;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 */
@Component(immediate = true)
@Service
public class SimpleRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
//        System.out.println("request st");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        System.out.println("req dest");
    }
}
