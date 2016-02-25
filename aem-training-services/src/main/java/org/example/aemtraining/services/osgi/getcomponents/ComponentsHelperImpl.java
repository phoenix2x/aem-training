package org.example.aemtraining.services.osgi.getcomponents;

import org.apache.felix.scr.ScrService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import java.io.IOException;
import java.util.Dictionary;

/**
 */
@Component(immediate = true)
@Service
public class ComponentsHelperImpl implements ComponentsHelper {

    @Reference
    private ConfigurationAdmin configurationAdmin;

    @Reference
    private ScrService scrService;

    public Dictionary getComponentsProperties(String name) throws IOException {
        //if config exists in sling:OsgiConfig node only
        Configuration configuration = configurationAdmin.getConfiguration(name);
        return configuration.getProperties();
    }

    public Dictionary getComponentPropsUsingScr(String name) {
        org.apache.felix.scr.Component component = getComponent(name);
        return component.getProperties();
    }

    private org.apache.felix.scr.Component getComponent(String name) {
        org.apache.felix.scr.Component[] components = scrService.getComponents(name);
        if ((components != null) && (components.length > 0)) {
            return components[0];
        }
        return null;
    }
}
