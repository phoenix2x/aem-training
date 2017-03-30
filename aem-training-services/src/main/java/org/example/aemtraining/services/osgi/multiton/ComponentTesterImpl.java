package org.example.aemtraining.services.osgi.multiton;

import org.apache.felix.scr.ScrService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import java.io.IOException;

/**
 */
@Component(immediate = true)
@Service
public class ComponentTesterImpl implements ComponentTester {
    @Reference
    private ConfigurationAdmin configurationAdmin;

    @Reference
    private ScrService scrService;

    public void testComponents() throws IOException {
//        createComponents();
        org.apache.felix.scr.Component[] components = scrService.getComponents(MultiServiceManualDriven.MULTITON_NAME);
        MultiServiceManualDriven multiServiceManualDrivens = (MultiServiceManualDriven) components[0].getComponentInstance().getInstance();
        Configuration[] configurations;
        String bundleLocation;
        try {

            configurations = configurationAdmin.listConfigurations("(service.factoryPid=" + MultiServiceManualDriven.MULTITON_NAME + ")");
            bundleLocation = configurations[0].getBundleLocation();
        } catch (InvalidSyntaxException e) {
        }
        System.out.println("q");
    }

    private void createComponents() throws IOException {
        String pid1 = testConfigAdminDrivenMultiton("firstProp");
        String pid2 = testConfigAdminDrivenMultiton("secondProp");
    }

    private String testConfigAdminDrivenMultiton(String propValue) throws IOException {
        Configuration configuration = configurationAdmin.createFactoryConfiguration(MultiServiceManualDriven.MULTITON_NAME);
        java.util.Properties props = new java.util.Properties();
        props.put(MultiServiceManualDriven.TEST_PROP_NAME, propValue);
        configuration.update(props);
        return configuration.getPid();
    }
}
