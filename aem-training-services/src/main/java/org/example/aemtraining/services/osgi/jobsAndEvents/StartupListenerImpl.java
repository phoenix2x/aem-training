package org.example.aemtraining.services.osgi.jobsAndEvents;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.launchpad.api.StartupMode;
import org.apache.sling.launchpad.api.StartupListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * //DOES NOT WORK FOR SOME REASON
 */
@Component(immediate = true)
@Service(StartupListener.class)
public class StartupListenerImpl implements StartupListener {


    private static final Logger LOG = LoggerFactory.getLogger(StartupListenerImpl.class);


    @Override
    public void inform(StartupMode startupMode, boolean b) {
        LOG.error("startup_inform");
    }

    @Override
    public void startupFinished(StartupMode startupMode) {
        LOG.error("startup_finished");
    }

    @Override
    public void startupProgress(float v) {
        LOG.error("startup_progress");
    }
}
