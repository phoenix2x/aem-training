package org.example.aemtraining.services.osgi.bundletrackercustomizer;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.osgi.util.tracker.BundleTracker;

/**
 */
@Component(immediate = true)
@Service
public class MyBundleTrackerCustomizer implements BundleTrackerCustomizer {

    @Activate
    protected void activate(BundleContext bundleContext) {
        BundleTracker bundleTracker = new BundleTracker(bundleContext, Bundle.ACTIVE, this);
        bundleTracker.open();
    }

    @Override
    public Object addingBundle(final Bundle bundle, final BundleEvent bundleEvent) {
//        System.out.println("q");
        return null;
    }

    @Override
    public void modifiedBundle(final Bundle bundle, final BundleEvent bundleEvent, final Object o) {
//        System.out.println("q");
    }

    @Override
    public void removedBundle(final Bundle bundle, final BundleEvent bundleEvent, final Object o) {
//        System.out.println("q");
    }
}
