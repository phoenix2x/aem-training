package org.example.aemtraining.services.osgi.runmodes;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.runmode.RunMode;
import org.apache.sling.settings.SlingSettingsService;

import java.util.Map;
import java.util.Set;

/**
 */
@Component(immediate = true)
@Service(RunmodesTest.class)
public class RunmodesTest {

    @Reference
    private RunMode runMode;

    @Reference
    private SlingSettingsService slingSettingsService;

    private void testRunmode() {
        String[] runmodes = runMode.getCurrentRunModes();
        Set<String> runmodes2 = slingSettingsService.getRunModes();
    }
    @Activate
    protected void activate() {
        testRunmode();
    }
}
